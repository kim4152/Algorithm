import java.util.*

class Solution {
    data class Node(val x: Int, val y: Int, val count: Int, val isL: Boolean)

    fun solution(maps: Array<String>): Int {
        val map = maps.toList()
        val start = findStart(maps) ?: return -1
        val queue: Queue<Node> = LinkedList()
        val visited = Array(map.size) { Array(map[0].length) { BooleanArray(2) } } // [x][y][0] = L 미통과, [x][y][1] = L 통과

        queue.offer(Node(start.first, start.second, 0, false))
        visited[start.first][start.second][0] = true

        while (queue.isNotEmpty()) {
            val (x, y, count, isL) = queue.poll()

            if (isL && map[x][y] == 'E') return count // L을 지나고 도착점 도달하면 반환

            for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                val nx = x + dx
                val ny = y + dy

                if (nx in map.indices && ny in map[0].indices && map[nx][ny] != 'X') {
                    val nextL = isL || map[nx][ny] == 'L'
                    val lIndex = if (nextL) 1 else 0
                    if (!visited[nx][ny][lIndex]) {
                        visited[nx][ny][lIndex] = true
                        queue.offer(Node(nx, ny, count + 1, nextL))
                    }
                }
            }
        }
        return -1 // 도착 불가능
    }

    fun findStart(maps: Array<String>): Pair<Int, Int>? {
        for (x in maps.indices) {
            val y = maps[x].indexOf('S')
            if (y != -1) return x to y
        }
        return null
    }
}