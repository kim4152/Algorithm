import java.util.*
import kotlin.math.*
class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        val queue:Queue<Int> = LinkedList()
        queue.add(0)
        numbers.forEach{n->
            repeat(queue.size){
                val a = queue.poll()
                queue.add(a+n)
                queue.add(a-n)
            }
        }
        
        return queue.count{it==target}
    }
}