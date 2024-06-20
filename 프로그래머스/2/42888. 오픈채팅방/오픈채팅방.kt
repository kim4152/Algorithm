class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        
        val list = mutableListOf<Pair<String,String>>()
        val map = mutableMapOf<String,String>()
        
        record.forEach{
            if(it.substringBefore(" ") == "Enter"){
                val (action,id,name) = it.split(" ")
                list.add(Pair(id,action))
                map[id] = name
            }else if(it.substringBefore(" ") == "Leave"){
                val (action,id) = it.split(" ")
                list.add(Pair(id,action))
            }else{
                val (action,id,name) = it.split(" ")
                map[id] = name
            }
        }
        list.forEach{
            if(it.second == "Enter"){
                answer.add("${map[it.first]}님이 들어왔습니다.")
            }else{
                answer.add("${map[it.first]}님이 나갔습니다.")
            }
        }
        return answer.toTypedArray()
    }
}