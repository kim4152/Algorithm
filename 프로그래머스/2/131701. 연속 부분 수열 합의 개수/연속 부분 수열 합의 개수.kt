class Solution {
    fun solution(elements: IntArray): Int {
    val check = mutableSetOf<Int>()
    val n = elements.size
    val dp = elements.toMutableList()

    check.addAll(dp)

    for (i in 1 until n) {
        for (j in dp.indices) {
            dp[j] += elements[(i + j) % n]
        }
        check.addAll(dp)
    }

    return check.size
}


}