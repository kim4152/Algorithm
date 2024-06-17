class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0

        // 왼쪽과 오른쪽의 토핑 종류 수를 저장할 배열
        val leftCounts = IntArray(topping.size)
        val rightCounts = IntArray(topping.size)
        
        // 왼쪽에서부터 토핑 종류 수를 세는 세트
        val leftSet = mutableSetOf<Int>()
        for (i in topping.indices) {
            leftSet.add(topping[i])
            leftCounts[i] = leftSet.size
        }
        
        // 오른쪽에서부터 토핑 종류 수를 세는 세트
        val rightSet = mutableSetOf<Int>()
        for (i in topping.indices.reversed()) {
            rightSet.add(topping[i])
            rightCounts[i] = rightSet.size
        }
        
        // 두 부분의 토핑 종류 수가 같은 지점을 찾음
        for (i in 0 until topping.size - 1) {
            if (leftCounts[i] == rightCounts[i + 1]) {
                answer++
            }
        }

        return answer
    }
}