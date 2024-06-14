
lateinit var visite : Array<BooleanArray>
lateinit var arr : Array<IntArray>
var size:Int =0
var input : Int =0
fun main(args: Array<String>) {
     input = readLine()!!.toInt()
     arr = Array(input) { IntArray(input) }
     visite = Array(input) { BooleanArray(input) { false } }
    repeat(input) { it ->
        val str = readLine()!!
        str.forEachIndexed { index, c ->
            arr[it][index] += c.digitToInt()
        }
    }
    var total = 0
    var sizeArr = intArrayOf()




    arr.forEachIndexed { x, it ->
        it.forEachIndexed { y, intArr ->
            if (!visite[x][y] && arr[x][y] == 1) {
                visite[x][y] = true
                dfs(x, y)
                total++
                sizeArr += size +1
                size = 0
            }
        }
    }



    println(total)
    sizeArr.sort()
    sizeArr.forEach {
        println(it)
    }
}

fun dfs(x: Int, y: Int) {
        //x : 0  y:1
    if (x-1 >= 0 && !visite[x - 1][y] && arr[x - 1][y] == 1) {
        visite[x - 1][y]= true
        size++
        dfs(x - 1, y)
    }

    if (x+1 < input && !visite[x + 1][y] && arr[x + 1][y] == 1) {
        visite[x + 1][y] = true
        size++
        dfs(x + 1, y)
    }
    if (y-1 >= 0 && !visite[x][y - 1] && arr[x][y - 1] == 1  ) {
        visite[x][y - 1]= true
        size++
        dfs(x, y - 1)
    }
    if (y+1 < input && !visite[x][y + 1] && arr[x][y + 1] == 1  ) {
        visite[x][y + 1]= true
        size++
        dfs(x, y + 1)
    }
}