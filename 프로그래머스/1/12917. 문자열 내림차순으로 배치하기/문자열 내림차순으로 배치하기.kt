class Solution {
    fun solution(s: String): String {
        val sb = StringBuilder()
        val answer = s.toList().sortedDescending()
        answer.forEach{
            sb.append(it)
        }
        return sb.toString()
    }
}