class Solution {
    fun solution(word: String): Int {
    val vowels = charArrayOf('A', 'E', 'I', 'O', 'U')
    val positionValue = intArrayOf(781, 156, 31, 6, 1)  // 각 자리의 가중치 값

    var position = 0

    for (i in word.indices) {
        val charIndex = vowels.indexOf(word[i])
        position += positionValue[i] * charIndex + 1
    }

    return position
}
}