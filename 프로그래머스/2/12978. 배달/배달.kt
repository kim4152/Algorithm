import java.util.*

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val graph = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }

        // 인접 리스트로 그래프 구성
        road.forEach { (a, b, time) ->
            graph[a].add(Pair(b, time))
            graph[b].add(Pair(a, time))
        }

        // 다익스트라 알고리즘을 위한 우선순위 큐 (최소 힙)
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) // (노드, 거리)
        val dist = IntArray(N + 1) { Int.MAX_VALUE } // 최단 거리 저장
        dist[1] = 0 // 시작 노드는 거리 0
        pq.offer(1 to 0)

        while (pq.isNotEmpty()) {
            val (current, currentDist) = pq.poll()

            if (currentDist > dist[current]) continue // 이미 처리된 거리보다 길다면 무시

            for ((next, weight) in graph[current]) {
                val newDist = currentDist + weight
                if (newDist < dist[next]) {
                    dist[next] = newDist
                    pq.offer(next to newDist)
                }
            }
        }

        // k 이하의 거리 내에 있는 마을 수 반환
        return dist.count { it <= k }
    }
}