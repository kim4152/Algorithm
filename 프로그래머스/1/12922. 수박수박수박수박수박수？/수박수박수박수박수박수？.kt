class Solution {
    fun solution(n: Int): String {
        val sb = StringBuilder()
        repeat(n){it->
            if(it % 2==0) sb.append("수")
            else sb.append("박")
        }
        return sb.toString()
    }
}