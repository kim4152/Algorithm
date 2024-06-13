class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val size = (right - left + 1).toInt()
        val answer = IntArray(size)
        
        for (index in 0 until size) {
            val i = (left + index) / n
            val j = (left + index) % n
            answer[index] = Math.max(i, j).toInt() + 1
        }
        
        return answer
    }
}
