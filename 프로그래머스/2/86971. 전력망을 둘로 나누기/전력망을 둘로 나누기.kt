class Solution {
    var answer = 101
    val map  = mutableMapOf<Int, MutableList<Int>>()
    var startN = 0
    lateinit var top: BooleanArray
    
    fun solution(n: Int, wires: Array<IntArray>): Int {
        if (n == 2) return 0
        top = BooleanArray(n + 1) { true }
        
        wires.forEachIndexed { idx, _ ->
            // 맵 초기화
            map.clear()
            top.fill(true)
            
            // 전선 정보를 하나씩 빼고 맵에 추가
            for (i in wires.indices) {
                if (i == idx) continue
                addMap(wires[i][0], wires[i][1])
            }
            
            // 분리된 두 개의 네트워크로 나누기
            bfs(wires[idx][0])
            countFalse()
        }
        return answer
    }
    
    fun countFalse() {
        val a = top.count { !it }
        val b = top.size - a - 1
        makeAnswer(a, b)
    }
    
    fun bfs(start: Int) {
        val queue = ArrayDeque<Int>()
        queue.add(start)
        top[start] = false
        
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            map[node]?.forEach {
                if (top[it]) {
                    top[it] = false
                    queue.add(it)
                }
            }
        }
    }
    
    fun addMap(a: Int, b: Int) {
        map.computeIfAbsent(a) { mutableListOf() }.add(b)
        map.computeIfAbsent(b) { mutableListOf() }.add(a)
    }
    
    fun makeAnswer(a: Int, b: Int) {
        val c = kotlin.math.abs(a - b)
        answer = minOf(answer, c)
    }
}
