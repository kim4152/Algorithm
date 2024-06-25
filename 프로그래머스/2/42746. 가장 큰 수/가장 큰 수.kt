class Solution {
    fun solution(numbers: IntArray): String {
        val sort = numbers.map { it.toString() }.sortedWith{a,b -> (b+a).compareTo(a+b)}
    val sb = StringBuilder()
    sort.forEach{
        sb.append(it)
    }
    return if(sb.toString()[0] == '0') "0" else sb.toString()
    }
}