class Solution {
    fun solution(numbers: String): Int {
        val visited = BooleanArray(numbers.length) { false }
        val set = mutableSetOf<Int>()

        fun check(s: String) {
            val a = s.toInt()
            set.add(a)
        }

        fun fuc(str: String) {
            numbers.forEachIndexed { index, it ->
                if (!visited[index]) {
                    val i = str + it.toString()
                    check(i)
                    visited[index] = true
                    fuc(i)
                    visited[index] = false
                }
            }
        }

        numbers.forEachIndexed { index, it ->
            check(it.toString())
            visited[index] = true
            fuc(it.toString())
            visited[index] = false
        }

        fun check2(i: Int): Boolean {
            if (i <= 1) return false
            if (i == 2 || i == 3) return true
            if (i % 2 == 0 || i % 3 == 0) return false
            var k = 5
            while (k * k <= i) {
                if (i % k == 0 || i % (k + 2) == 0) return false
                k += 6
            }
            return true
        }

        var answer = 0
        set.forEach {
            if (check2(it)) answer++
        }

        return answer
    }
}
