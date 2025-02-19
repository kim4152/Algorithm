class Solution {
    lateinit var visited: Array<BooleanArray>
    lateinit var map: Array<String>
    fun solution(maps: Array<String>): IntArray {
        visited = Array(maps.size){ BooleanArray(maps[0].length) { false } }
        map = maps
        val answer = mutableListOf<Int>()

        maps.forEachIndexed{ x, str->
            str.forEachIndexed{ y, c ->
                if(!visited[x][y] && maps[x][y] != 'X'){
                    val result = dfs(x, y)
                    answer.add(result)
                }
                visited[x][y] = true
            }
        }
        return if(answer.size == 0){
            intArrayOf(-1)
        }else{
         answer.sorted().toIntArray()   
        }
    }
    
    fun dfs(x: Int, y: Int): Int{
        if(x in map.indices && y in map[0].indices && map[x][y] != 'X' && visited[x][y] == false){
            visited[x][y] = true
            var nSum = map[x][y].digitToInt()
            for( (nx,ny) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to  1) ){
                nSum += dfs(x+nx, y+ny)
            }
            return nSum
        }else{
            return 0
        }
    }
    
}