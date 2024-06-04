fun main() {
    val S = readLine()!!
    val stList = mutableSetOf<String>()
    
    for (i in S.indices) {
        for (j in i + 1..S.length) {
            stList.add(S.substring(i, j))
        }
    }
    
    print(stList.size)
}