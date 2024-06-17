import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stack = Stack<Int>()
        val answer = IntArray(numbers.size) { -1 }

        for (i in numbers.indices) {

            while (stack.isNotEmpty() && numbers[stack.peek()] < numbers[i]) {

                answer[stack.peek()] = numbers[i]
                stack.pop()

            }
            stack.add(i)
        }
        return answer
    }
}