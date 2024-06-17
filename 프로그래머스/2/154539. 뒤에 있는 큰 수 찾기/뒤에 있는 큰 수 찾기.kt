class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        val stack = mutableListOf<Int>()

        for (i in numbers.indices) {
            while (stack.isNotEmpty() && numbers[stack.last()] < numbers[i]) {
                val index = stack.removeAt(stack.size - 1)
                answer[index] = numbers[i]
            }
            stack.add(i)
        }

        return answer
    }
}