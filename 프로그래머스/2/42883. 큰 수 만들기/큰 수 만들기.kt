import java.util.*
class Solution {
    fun solution(number: String, k: Int): String {
    val result = IntArray(number.length-k)
    var count = k
    val stack = Stack<Char>()
    for(i in number.indices){

        while (stack.size>0 && count>0 && stack.peek() < number[i]){
            count--
            stack.pop()
        }

        if (stack.size < result.size){
            stack.add(number[i])
        }
    }
    val sb = StringBuilder()
    stack.forEach { sb.append(it) }
    return sb.toString()
}
}