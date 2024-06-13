class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val wantMap = mutableMapOf<String,Int>()
        val tmpMap = mutableMapOf<String,Int>()
        var numberSum = 0
        var answer = 0
        want.forEachIndexed{index,it->
            numberSum += number[index]
            wantMap[it] = number[index]
        }
        for(i in 0 .. discount.size - numberSum ){
            for(j in i until i+numberSum){
                tmpMap[discount[j]] = (tmpMap[discount[j]]?:0)+1
            }
            if(wantMap == tmpMap) answer ++
            tmpMap.clear()
        }
        
        return answer
    }
}