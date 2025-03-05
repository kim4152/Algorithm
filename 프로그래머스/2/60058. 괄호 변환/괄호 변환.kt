import java.util.*

class Solution {
    fun solution(p: String): String {
        return j(p)
    }
    fun j(p: String): String {
        if(p == "") return ""
        val (u,v) = splitString(p)
        if(isCorrect(u)){
            return u + j(v)
        }else{
            return i(u, v)
        }
    }

    fun i(u: String, v: String): String {
        val removed = u.drop(1).dropLast(1)
        val result = buildString{
            append('(')
            append("${j(v)}")
            append(')')
            removed.forEach{ c ->
                if(c == '(') append(')')
                if(c == ')') append('(')
            }
        }
        return result
    }

    fun splitString(p: String): Pair<String,String> {
        var openCount = 0
        var closeCount = 0

        p.forEachIndexed{ idx, it ->
            if(it == '(') openCount++
            if(it == ')') closeCount++
            if(openCount == closeCount) {
                return Pair(p.substring(0,idx+1), p.substring(idx+1,p.length))
            }
        }
        return Pair("","")
    }

    fun isCorrect(p: String): Boolean {
        val stack = Stack<Char>()
        p.forEach{
            if(stack.isEmpty()) stack.add(it)
            else{
                val peek = stack.peek()
                if(peek == '(' && it == ')'){
                    stack.pop()
                }else{
                    stack.add(it)
                }
            }
        }
        return if(stack.isEmpty()) true else false
    }
}