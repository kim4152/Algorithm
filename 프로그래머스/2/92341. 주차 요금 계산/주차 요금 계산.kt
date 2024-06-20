import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val map = mutableMapOf<String, String>()
        val resultMap = mutableMapOf<Int, Int>()
        val total = mutableMapOf<Int, Int>()

        fun fuc(timeA: String, timeB: String, number: Int) {
            val tA = sub(timeA)
            val tB = sub(timeB)
            val res = tA - tB
            total[number] = total.getOrDefault(number, 0) + res
        }

        records.forEach { it ->
            val (time, number, action) = it.split(" ")
            val num = number.toIntOrNull()
            if (num != null) {
                if (action == "IN") {
                    map[number] = time
                } else {
                    map.remove(number)?.let { inTime ->
                        fuc(time, inTime, num)
                    }
                }
            }
        }

        if (map.isNotEmpty()) {
            map.forEach { (k, v) ->
                val num = k.toIntOrNull()
                if (num != null) {
                    fuc("23:59", v, num)
                }
            }
        }

        total.forEach { (k, v) ->
            val price = if (v > fees[0]) {
                fees[1] + ceil((v - fees[0]) / fees[2].toDouble()).toInt() * fees[3]
            } else {
                fees[1]
            }
            resultMap[k] = price
        }

        return resultMap.entries.sortedWith(compareBy { it.key }).map { it.value }.toIntArray()
    }

    fun sub(time: String): Int {
        val be = time.substringBefore(":").toInt()
        val af = time.substringAfter(":").toInt()
        return be * 60 + af
    }
}
