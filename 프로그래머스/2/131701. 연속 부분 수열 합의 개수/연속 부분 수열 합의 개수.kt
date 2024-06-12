class Solution {
    fun solution(elements: IntArray): Int {
    val n = elements.size
    val uniqueSums = mutableSetOf<Int>()

    // 모든 길이의 부분 수열에 대해 합을 계산
    for (length in 1..n) {
        for (start in 0 until n) {
            var sum = 0
            for (i in 0 until length) {
                sum += elements[(start + i) % n]
            }
            uniqueSums.add(sum)
        }
    }

    return uniqueSums.size
}
}