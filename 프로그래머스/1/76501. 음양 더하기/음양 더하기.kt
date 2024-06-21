class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        signs.forEachIndexed{index,it->
            if(it) answer += absolutes[index]
            else answer -= absolutes[index]
        }
        return answer
    }
}