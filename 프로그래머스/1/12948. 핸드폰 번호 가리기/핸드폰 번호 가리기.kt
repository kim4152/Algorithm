class Solution {
    fun solution(phone_number: String): String {
        val sb = StringBuilder()
        phone_number.forEachIndexed { index, c -> 
            if (index in (0 until  phone_number.length-4)){
                sb.append("*")
            }else{
                sb.append(c)
            }
        }
        
        return sb.toString()
    }
}