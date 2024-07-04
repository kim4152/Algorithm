class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var sum: Long = 0
        repeat(count){
            sum+= (it+1) * price
        }
        
        if(sum-money > 0){
            return sum - money
        }else{
            return 0
        }
    }
}