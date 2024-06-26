class Solution {
    fun solution(n: Int): IntArray {
    val arr = Array(n) { IntArray(n) { -1 } }
    val end = getEnd(n)
    var x = 0;
    var y = 0
    var i = 1

    for (i in 0 until n) {
        for (j in 0..i) {
            arr[i][j] = 0
        }
    }
    println("end = ${end}")

    arr[0][0] = 1

    var state = State.xup
    while (i < end) {

        when (state) {
            State.xup -> {
                if (x < n-1 && arr[x + 1][y] == 0) {
                    x++; i++
                    arr[x][y] = i
                } else {
                    state = State.yup
                }

            }

            State.yup -> {
                if (y < n-1 && arr[x][y + 1] == 0) {
                    y++; i++
                    arr[x][y] = i
                } else {
                    state = State.xydown
                }

            }

            State.xydown -> {
                if (x > 1 && y > 1 && arr[x - 1][y - 1] == 0) {
                    x--; y--; i++
                    arr[x][y] = i
                } else {
                    state = State.xup
                }

            }
        }
    }

    return arr.flatMap { it.toList() }.filter{it != -1}.toIntArray()
}
    fun getEnd(i: Int): Int {
    if (i <= 1) return 1
    return i + getEnd(i - 1)
}
}
enum class State {
    xup, yup, xydown
}