class Solution {
    fun solution(num: Int): Int {
        var input = num.toLong()
        var count = 0
        while(input != 1L){
            if(input % 2 == 0L){
                input /= 2
            } else {
                input = input * 3 + 1
            }
            count++
            if(count == 500) return -1
        }
        return count
    }
}
