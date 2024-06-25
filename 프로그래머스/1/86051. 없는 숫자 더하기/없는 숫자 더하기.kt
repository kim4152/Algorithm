class Solution {
    fun solution(numbers: IntArray): Int {
         val set = mutableSetOf<Int>()
         var sum = 0
         numbers.forEach{
             sum+=it
         }
        
        return 45-sum
    }
}