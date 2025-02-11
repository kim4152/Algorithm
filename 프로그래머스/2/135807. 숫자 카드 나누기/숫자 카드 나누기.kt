import kotlin.math.*

class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val gcdA = arrayA.reduce { acc, num -> gcd(acc, num) }
        val gcdB = arrayB.reduce { acc, num -> gcd(acc, num) }

        val maxA = if (arrayB.any { it % gcdA == 0 }) 0 else gcdA
        val maxB = if (arrayA.any { it % gcdB == 0 }) 0 else gcdB

        return max(maxA, maxB)
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}