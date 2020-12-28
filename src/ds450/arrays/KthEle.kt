package ds450.arrays

import java.lang.IllegalArgumentException
import java.util.*

class KthEle {
    fun kMaxEle(nums: IntArray, k: Int) : Int {
        if (nums.isEmpty())
            throw IllegalArgumentException()
        var minQueue = PriorityQueue<Int> {a, b -> a - b}

        for(index in 0 until k){
            minQueue.add(nums[index])
        }

        for (index in k until nums.size) {
            if(minQueue.peek() < nums[index]){
                minQueue.poll()
                minQueue.add(nums[index])
            }
        }
        return minQueue.peek()
    }

    fun kMinEle(nums: IntArray, k: Int) : Int {
        if (nums.isEmpty())
            throw IllegalArgumentException()
        var maxQueue = PriorityQueue<Int> {a, b -> b - a}

        for(index in 0 until k){
            maxQueue.add(nums[index])
        }

        for (index in k until nums.size) {
            if(maxQueue.peek() > nums[index]){
                maxQueue.poll()
                maxQueue.add(nums[index])
            }
        }
        return maxQueue.peek()
    }
}