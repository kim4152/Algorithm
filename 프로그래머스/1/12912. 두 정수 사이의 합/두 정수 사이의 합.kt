class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        val x = minOf(a,b)
        val y = maxOf(a,b)
        for(i in x .. y){
            answer += i
        }
        return answer
    }
}