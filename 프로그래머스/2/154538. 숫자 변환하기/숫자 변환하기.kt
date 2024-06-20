import java.util.*
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
    if (x == y) return 0

    var index = 1
    val queue: Queue<Int> = LinkedList()
    val visited: MutableSet<Int> = mutableSetOf(x)
    queue.add(x)
    
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val poll = queue.poll()
            val a = poll * 2
            val b = poll * 3
            val c = poll + n
            
            if (a == y || b == y || c == y) {
                return index
            }
            
            if (a < y && a !in visited) {
                queue.add(a)
                visited.add(a)
            }
            
            if (b < y && b !in visited) {
                queue.add(b)
                visited.add(b)
            }
            
            if (c < y && c !in visited) {
                queue.add(c)
                visited.add(c)
            }
        }
        index++
    }
    return -1
}

}