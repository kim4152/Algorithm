import java.util.*

class Solution {
    data class Node(val x: Int, val y: Int, val count: Int, val isL: Boolean)
    fun solution(maps: Array<String>): Int {
        val (startX, startY) = findStart(maps) ?: return -1
        val answer = bfs(Node(startX, startY, 0, false), maps)
        return answer
    }

    fun bfs( node: Node,  maps: Array<String>): Int{
        val queue : Queue<Node> = LinkedList()
        val visited = Array(maps.size){Array(maps[0].length){BooleanArray(2)}}
        
        queue.offer(node)

        while(queue.isNotEmpty()){
            val (x, y, count, isL) = queue.poll()
            if(isL && maps[x][y] == 'E') return count
            
            for( (dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1) ){
                val nx = x + dx
                val ny = y + dy
                
                if (nx in maps.indices && ny in maps[0].indices && maps[nx][ny] != 'X') {
                    val nextL = isL || maps[nx][ny] == 'L'
                    val lIndex = if (nextL) 1 else 0
                    if (!visited[nx][ny][lIndex]) {
                        visited[nx][ny][lIndex] = true
                        queue.offer(Node(nx, ny, count + 1, nextL))
                    }
                }
            }
        }
        return -1
    }


    fun findStart(maps: Array<String>): Pair<Int,Int>?{
        maps.forEachIndexed{ x, s ->
            s.forEachIndexed{ y, c ->
                if(c == 'S') return Pair(x, y)
            }
        }
        return null
    }
}