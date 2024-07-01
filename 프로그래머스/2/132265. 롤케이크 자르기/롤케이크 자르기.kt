class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0

        val leftCounts = IntArray(topping.size)
        val rightCounts = IntArray(topping.size)
        
        val leftSet = mutableSetOf<Int>()
        for (i in topping.indices) {
            leftSet.add(topping[i])
            leftCounts[i] = leftSet.size
        }
        
        val rightSet = mutableSetOf<Int>()
        for (i in topping.indices.reversed()) {
            rightSet.add(topping[i])
            rightCounts[i] = rightSet.size
        }
        
        for (i in 0 until topping.size - 1) {
            if (leftCounts[i] == rightCounts[i + 1]) {
                answer++
            }
        }

        return answer
    }
}