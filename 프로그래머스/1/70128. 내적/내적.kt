class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        var sum = 0
        for(i in a.indices){
           sum += a[i] * b[i]
        }
        return sum
    }
}