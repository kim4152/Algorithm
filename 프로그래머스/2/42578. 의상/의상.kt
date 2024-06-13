class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
    // 옷의 종류별로 개수를 저장하는 맵
    val clothesMap = mutableMapOf<String, Int>()
    
    // 옷의 종류별로 개수를 계산
    for (cloth in clothes) {
        val type = cloth[1]
        clothesMap[type] = clothesMap.getOrDefault(type, 0) + 1
    }
    
    // 가능한 모든 조합의 수를 계산
    var answer = 1
    for (count in clothesMap.values) {
        // 각 종류별로 옷을 입지 않는 경우를 포함하여 계산
        answer *= (count + 1)
    }
    
    // 모든 옷을 입지 않는 경우를 제외
    return answer - 1
}
}