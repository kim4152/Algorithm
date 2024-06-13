import java.util.*
import java.math.*
import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        val queue:Queue<Int> = LinkedList()
        progresses.forEach{
            queue.add(it)
        }
        var index = 0
        var count = 0
        while(queue.isNotEmpty()){
            val n = ceil((100-queue.peek())/speeds[index].toFloat()).toInt()
            while(queue.isNotEmpty()){
                if(queue.peek() + n * speeds[index] >= 100){
                    queue.poll()
                    index++
                    count++
                }else{
                    answer+=count
                    count = 0
                    break
                }
            }
        }
        answer+=count
        return answer
    }
}