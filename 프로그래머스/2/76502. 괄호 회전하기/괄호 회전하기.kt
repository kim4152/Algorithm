import java.util.*
class Solution {
    fun solution(s: String): Int {
    var answer: Int = 0

    val queue: Queue<Char> = LinkedList()
    s.forEach {
        queue.add(it)
    }
    repeat(s.length) {
        val a = queue.poll()
        queue.add(a)
        if (check(queue.joinToString(separator = ""))) answer++
    }
    return answer
}

fun check(str: String): Boolean {
    val stack = Stack<Char>()
    val map = mapOf<Char, Char>('[' to ']', '{' to '}', '(' to ')')
    stack.add(str[0])
    try{
        for (i in 1 until str.length  ) {
            if (stack.isEmpty()){
                stack.add(str[i])
            }else if (map[stack.peek()] == str[i]) {
                stack.pop()
            }else{
                stack.add(str[i])
            }
        }
    }catch (e:Exception){
        return false
    }

    if (stack.isEmpty()){
        return true
    }else{
        return false
    }
}
}