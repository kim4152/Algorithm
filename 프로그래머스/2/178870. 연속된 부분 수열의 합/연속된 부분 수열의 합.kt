import java.util.*
class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
    var start = 0
    var sum = 0
    var minLength = Int.MAX_VALUE
    var answer = intArrayOf(-1, -1)

    for (end in sequence.indices) {
        sum += sequence[end]

        while (sum >= k) {
            if (sum == k) {
                if (end - start < minLength) {
                    minLength = end - start
                    answer[0] = start
                    answer[1] = end
                }
            }
            sum -= sequence[start]
            start++
        }
    }

    return answer
}

}