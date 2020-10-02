package design

/**
 * Give the hit counter of last 5mins
 * https://leetcode.com/problems/design-hit-counter/
 * leetCode  362
 */

import java.util.LinkedList

class HiitCounter {

    // Counter based approach

    private val callCounter = IntArray(3001)
    private val timeCounter = IntArray(3001)

    fun hitCounter(t: Int): Int {
        val index = t % 3001
        if(timeCounter[index] != t){
            timeCounter[index] = t
            callCounter[index] = 1
        } else {
            callCounter[index] += 1
        }

        var count = 0
        for(i in callCounter.indices){
            if(timeCounter[i] != 0 && timeCounter[i] >= t - 3000 && timeCounter[i] <= t){
                count++
            }
        }
        return count
    }

    // Queue based approach
    private val queue = LinkedList<Int>()

    fun ping(t: Int): Int {
        queue.add(t)

        while(queue.isNotEmpty()){
            if(queue.peek() < t - 3000){
                queue.remove()
            }else{
                break
            }
        }



        return queue.size
    }

}