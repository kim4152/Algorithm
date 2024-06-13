import java.util.*
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        fun initQ(queue:Queue<Q>):Queue<Q>{
            var index = queue.withIndex().maxByOrNull{it.value.priority}!!.index
            while(index!=0){
                queue.add(queue.poll())
                index--
            }
            return queue
        }

        var answer = 0

        val queue:Queue<Q> = LinkedList<Q>()
        priorities.forEachIndexed{index,it->
            if(index==location){
                queue.add(Q(it,true))
            }else{
                queue.add(Q(it,false))
            }
        }

        while(queue.isNotEmpty()){
            //println(queue)
            if(initQ(queue).poll().check){
                answer++
                return answer
            }
            answer++
        }

        //answer++
        return answer
    }
}
data class Q(val priority:Int, val check:Boolean)