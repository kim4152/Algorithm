import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()
        
        var index = 0
        var num = 1
        
        while (index < order.size) {
            if (stack.isNotEmpty() && stack.peek() == order[index]) {
                stack.pop()
                index++
                answer++
            } else if (order[index] == num) {
                num++
                index++
                answer++
            } else {
                if (order[index] < num) {
                    break
                } else if (num <= order.size) {
                    stack.push(num)
                    num++
                } else {
                    break
                }
            }
        }
        return answer
    }
}
