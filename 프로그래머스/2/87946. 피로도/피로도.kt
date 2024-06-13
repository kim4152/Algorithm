class Solution {
    lateinit var check:BooleanArray
var answer:Int =-1
lateinit var dungeon : Array<IntArray>

fun solution(k: Int, dungeons: Array<IntArray>): Int {
     check = BooleanArray(dungeons.size){false}
    dungeon = dungeons

    dungeons.forEachIndexed {index,it->
        if (k>=it[0] && !check[index]){
            check[index] = true
            dfs(k-it[1],index,1)
            check[index] = false
        }
    }

    return answer
}
fun dfs(hp:Int,index:Int,count:Int){
    answer = maxOf(answer,count)
    dungeon.forEachIndexed{idx,it->
        if(!check[idx] && hp>=it[0]){
            check[idx] = true
            dfs(hp-it[1],idx,count+1)
            check[idx] =false
        }
    }
}
}