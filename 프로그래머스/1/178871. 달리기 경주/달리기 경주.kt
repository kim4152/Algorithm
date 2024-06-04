class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    var answer: Array<String> = arrayOf<String>()
    val nameMap = hashMapOf<String,Int>()
    val rankMap = hashMapOf<Int ,String>()

    players.forEachIndexed { index, s ->
        nameMap[s] = index+1
        rankMap[index+1] = s
    }
    callings.forEach {
        val rank = nameMap[it]!!

        //rankMap 수정
        val tmp = rankMap[rank-1]!!
        rankMap[rank-1] = it
        rankMap[rank] = tmp

        //nameMap 수정
        nameMap[it] = rank-1
        nameMap[tmp] = rank
    }
    answer = rankMap.values.toTypedArray()

    return answer
}
}