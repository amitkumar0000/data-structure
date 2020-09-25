package array

import java.util.Stack

class NextGreaterEle {

    fun nextGreaterEleBruteForce(nums: IntArray): IntArray {
        var out = IntArray(nums.size) { -1 }
        for (i in nums.size - 1 downTo 0) {
            for (j in i + 1 until nums.size) {
                if (nums[j] > nums[i]) {
                    out[i] = nums[j]
                    break
                }
            }
        }
        return out
    }

    // Greater element to Right
    fun nextGreaterEle(nums: IntArray): IntArray {
        if (nums.isEmpty()) return intArrayOf()
        var out = IntArray(nums.size) { -1 }
        var stack = Stack<Int>()
        for (i in nums.size - 1 downTo 0) {
            while (stack.isNotEmpty() && stack.peek() <= nums[i])
                stack.pop()
            if (stack.isNotEmpty())
                out[i] = stack.peek()
            stack.push(nums[i])
        }
        return out
    }

    // Greater element to left
    fun nextGreaterEleLeft(nums: IntArray): IntArray {
        if(nums.isEmpty()) return intArrayOf()
        var out = IntArray(nums.size) {-1}
        var stack = Stack<Int>()

        for(i in nums.indices) {
            while(stack.isNotEmpty() && stack.peek() <= nums[i]) {
                stack.pop()
            }
            if(stack.isNotEmpty()){
                out[i] = stack.peek()
            }
            stack.push(nums[i])
        }
        return out
    }
}