class Solution {
    var one = 0
    var zero = 0
    lateinit var array: Array<IntArray>
    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        array = arr
        func(0, 0, arr.size)
        return listOf(zero, one).toIntArray()
    }
    
    fun func(x: Int, y: Int, size: Int){
        if(allSame(x, y, size)){
            if(array[x][y] == 1) {
                one++
            }
            else{
                zero++
            } 
            return
        }
        
        val n = size / 2
        func(x, y, n)
        func(x, y+n, n)
        func(x+n, y, n)
        func(x+n, y+n, n)
    }

    fun allSame(x: Int, y: Int, size: Int): Boolean{
        var sum = 0
        for(i in x until x+size){
            for(j in y until y+size){
                sum+=array[i][j]
            }
        }
        return if(sum == 0 || sum == (size*size)) true else false
    }
}