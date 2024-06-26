class Solution {
    fun solution(arr: IntArray): IntArray {
        if(arr.size < 2) return intArrayOf(-1)
        val list = arr.toMutableList()
        
        var min = Int.MAX_VALUE
        var index = 0
        list.forEach{it->
            if(it<min) {
                min = it
            }
        }
        list.remove(min)
        
        return list.toIntArray()
    }
}