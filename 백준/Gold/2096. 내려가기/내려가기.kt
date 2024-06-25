fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    var current = br.readLine().split(" ").map { it.toInt() }
    var minDP = current.toIntArray()
    var maxDP = current.toIntArray()

    for (i in 1 until n) {
        val next = br.readLine().split(" ").map { it.toInt() }
        val nextMin = IntArray(3)
        val nextMax = IntArray(3)

        for (j in 0..2) {
            val left = if (j > 0) minDP[j - 1] else Int.MAX_VALUE
            val right = if (j < 2) minDP[j + 1] else Int.MAX_VALUE
            val mid = minDP[j]
            nextMin[j] = minOf(left, right, mid) + next[j]

            val leftMax = if (j > 0) maxDP[j - 1] else Int.MIN_VALUE
            val rightMax = if (j < 2) maxDP[j + 1] else Int.MIN_VALUE
            val midMax = maxDP[j]
            nextMax[j] = maxOf(leftMax, rightMax, midMax) + next[j]
        }

        minDP = nextMin
        maxDP = nextMax
    }

    println("${maxDP.maxOrNull()} ${minDP.minOrNull()}")
}
