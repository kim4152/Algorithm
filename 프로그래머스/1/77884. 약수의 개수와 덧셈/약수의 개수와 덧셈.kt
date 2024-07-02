import kotlin.math.*
class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for(i in left .. right){
            if(count(i)) answer += i
            else answer -= i
        }
        return answer
    }
    fun count(i:Int):Boolean{
        var count = 0
        val j = Math.sqrt(i.toDouble())
        for(k in 1 .. j.toInt()){
            if(i % k == 0){
                if(k.toDouble() == j){
                    count += 1
                }else{
                    count += 2
                }
            }
        }
        if(count %2 ==0) return true
        else return false
    }
}