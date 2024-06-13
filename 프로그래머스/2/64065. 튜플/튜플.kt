class Solution {
    fun solution(s: String): IntArray {
        val str = s.substring(2, s.length - 2).split("},{").sortedBy{ it.length }
        val answer = mutableListOf<Int>()
        str.forEach{ row -> row.split(",").forEach{ if(!answer.contains(it.toInt())) answer.add(it.toInt()) }}
        return answer.toIntArray()
    }
}