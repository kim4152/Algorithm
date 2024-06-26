class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size){ IntArray(arr2[0].size) }
        for(i in 0 until arr1.size){
            for(j in 0 until arr2[0].size){
                var sum = 0
                for(k in 0 until arr2.size){
                    sum+=arr1[i][k] * arr2[k][j]
                }
                answer[i][j] = sum
            }
        }

        return answer
    }
}