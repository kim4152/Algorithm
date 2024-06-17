class Solution {
    fun solution(elements: IntArray): Int {
    val n = elements.size
    val sum = mutableSetOf<Int>()

    for (length in 1..n) {
        for (start in 0 until n) {
            var a = 0
            for (i in 0 until length) {
                a += elements[(start + i) % n]
            }
            sum.add(a)
        }
    }

    return sum.size
}



}