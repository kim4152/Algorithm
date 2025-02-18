class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val sortedOrders = orders.map {
            it.toList().sorted().joinToString("")
        }
        val orderMap = mutableMapOf<String,Int>()
        val answer = mutableListOf<String>()
        course.map { course ->
            orderMap.clear()
            sortedOrders.forEach { str->
                combi(course, 0, str, "", orderMap)
            }
            val key = orderMap.maxOfOrNull { it.value } ?: 0
            if (key >= 2){
                orderMap.filter { it.value == key }.map {
                    answer.add(it.key)
                }
            }
        }
        return answer.sorted().toTypedArray()
    }

    fun combi(course: Int, now: Int, order: String, ordercombi: String, orderMap: MutableMap<String, Int>) {
        if (course == 0) {  
            orderMap[ordercombi] = orderMap.getOrDefault(ordercombi, 0) + 1
            return
        }

        for (i in now until order.length) {
            combi(course - 1, i + 1, order, ordercombi + order[i], orderMap)
        }
    }
}