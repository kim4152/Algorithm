import java.util.*

class Solution {
    data class Server(val open: Int, val close: Int)

    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0
        val serverList: Queue<Server> = LinkedList()
        players.forEachIndexed{idx, people ->
            if(people == 0) return@forEachIndexed
            // 만료된 서버 삭제
            removeServer(serverList, idx)
            // people 에 따라 서버 증설
            val needServer = needServerCount(people, m)
            val addServer =  needServer - serverList.size
            if(addServer > 0) answer += addServer
            repeat(addServer){
                val server = Server(idx, idx+k-1)
                serverList.add(server)
            }
        }
        return answer
    }

    fun removeServer(serverList: Queue<Server>, currentTime: Int){
        while (serverList.isNotEmpty() && serverList.peek().close < currentTime){
            serverList.poll()
        }
    }

    fun needServerCount(people: Int, m: Int): Int {
        return if(people == 0) 0
        else people / m
    }
}