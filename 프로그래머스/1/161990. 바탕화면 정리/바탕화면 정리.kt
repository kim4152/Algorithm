class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
    var a =51; var b=51; var c =0; var d =-1
    wallpaper.forEachIndexed { x, s ->
        s.forEachIndexed { y, ch ->
            if (ch == '#'){
                if (x<a) a = x
                if (y<b) b = y
                if (x>c) c = x
                if (y>d) d = y
            }
        }
    }
    var answer: IntArray = intArrayOf(
        a,b,c+1,d+1
    )

    return answer
}
}