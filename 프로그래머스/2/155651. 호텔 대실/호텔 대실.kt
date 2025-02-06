import java.util.PriorityQueue

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val times = book_time.map { 
            Pair(strToTime(it[0]), strToTime(it[1]) + 10) 
        }.sortedBy { it.first }

        val pq = PriorityQueue<Int>()  // 가장 빨리 끝나는 예약을 추적
        for ((start, end) in times) {
            if (pq.isNotEmpty() && pq.peek() <= start) {
                pq.poll()  // 기존 방 재사용 가능하면 제거
            }
            pq.add(end)  // 새로운 예약 추가
        }
        return pq.size
    }

    private fun strToTime(time: String): Int {
        val (h, m) = time.split(":").map { it.toInt() }
        return h * 60 + m
    }
}