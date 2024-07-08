class Solution {
    fun solution(s: String): Boolean {
        if (s.length != 4 && s.length != 6) return false

        for (i in s) {
            if (!(i in '0'..'9')) return false
        }

        return true
    }
}
