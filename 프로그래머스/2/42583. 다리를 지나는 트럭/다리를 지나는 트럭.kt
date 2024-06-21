import java.util.*
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var index = 0
        val queue : Queue<Int> = LinkedList()
        
        fun addQ(i:Int){
            if(queue.size >= bridge_length){
                queue.poll()
                queue.add(i)
            }else{
                queue.add(i)
            }
        }
        repeat(bridge_length){
            queue.add(0)
        }
        
        while(index < truck_weights.size){
            queue.poll()
            if(queue.sum() +truck_weights[index] >weight){
               addQ(0)
            }else{
                addQ(truck_weights[index])
                index++
            }
            answer++
        }
        
        return answer + bridge_length
    }
}