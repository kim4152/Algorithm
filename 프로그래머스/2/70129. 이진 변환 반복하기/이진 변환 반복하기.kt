class Solution {
    fun solution(s: String): IntArray {

        var str = s
        var removeCount = 0
        var  count = 0

        while(str != "1"){
            val (afterStr, rCount) = str.replaceCount()
            str = afterStr
            removeCount += rCount.toInt()
            count ++
        }

        return listOf(count, removeCount).toIntArray()
    }

    fun String.replaceCount(): List<String>{
        var count = 0
        this.forEach{
            if(it == '0') count ++
        }
        val a = this.length - count
        return listOf("${a.toString(2)}", "${count}") 
    }
}