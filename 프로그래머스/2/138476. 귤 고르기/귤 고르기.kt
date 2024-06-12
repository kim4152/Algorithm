class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        var j = k
        val arr = Array<MutableList<Int>>(tangerine.size+1){mutableListOf()}
        val map = mutableMapOf<Int,Int>().withDefault { 0 }
        tangerine.forEach{
            map[it] = map.getValue(it)+1
        }

        map.forEach{ (k, v) ->
            arr[v].add(k)
        }
        for(i in tangerine.size downTo 1){
            if(arr[i].isNotEmpty()){
                arr[i].forEach{ _ ->
                    if(j-i>0){
                        j = j- i
                        answer++
                    }else{
                        answer ++
                        return answer
                    }
                    if (j<=0) return answer
                }
            }
        }
        return answer
    }
}