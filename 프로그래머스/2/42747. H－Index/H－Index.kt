class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        val size = citations.size
        val arr = citations.sortedDescending()
        arr.forEachIndexed { index, it ->
            if(index+1 <= it){
                answer = index+1
            }
        }

        return answer
    }
}