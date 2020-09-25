package array

import java.util.Stack

class NextSmallerEle {
    fun nextSmallerEle(nums: IntArray): IntArray {
        if(nums.isEmpty()) return intArrayOf()
        var out = IntArray(nums.size) {-1}
        var stack = Stack<Int>()

        for(i in nums.size - 1 downTo 0){
            while(stack.isNotEmpty() && stack.peek() >= nums[i])
                stack.pop()
            if(stack.isNotEmpty())
                out[i] = stack.peek()
            stack.push(nums[i])
        }
        return out
    }

    fun nextSmallerEleLeft(nums: IntArray): IntArray {
        if(nums.isEmpty()) return intArrayOf()
        var out = IntArray(nums.size) {-1}
        var stack = Stack<Int>()

        for(i in nums.indices){
            while(stack.isNotEmpty() && stack.peek() >= nums[i])
                stack.pop()
            if(stack.isNotEmpty())
                out[i] = stack.peek()
            stack.push(nums[i])
        }
        return out
    }
}