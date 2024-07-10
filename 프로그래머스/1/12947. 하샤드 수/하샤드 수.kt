class Solution {
    fun solution(x: Int): Boolean {
        var sum = 0 
        x.toString().forEach{
            sum+=it.digitToInt()
        }
        return if(x % sum == 0) true 
        else false
        
    }
}