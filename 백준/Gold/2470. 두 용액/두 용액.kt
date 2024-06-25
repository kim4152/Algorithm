fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var answer = Int.MAX_VALUE
    var node = IntArray(2)

    arr.sort()

    var minP = 0
    var maxP = arr.size - 1

    while (minP < maxP) {
        val sum = arr[minP] + arr[maxP]
        val absSum = kotlin.math.abs(sum)

        if (absSum < answer) {
            answer = absSum
            node[0] = arr[minP]
            node[1] = arr[maxP]
        }

        if (sum > 0) {
            maxP--
        } else {
            minP++
        }
    }

    br.close()
    println(node.joinToString(" "))
}
