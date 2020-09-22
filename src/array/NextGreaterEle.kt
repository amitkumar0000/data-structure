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

    fun nextGreaterEle(nums: IntArray): IntArray {
        var out = IntArray(nums.size) { -1 }

        var stack = Stack<Int>()
        for (i in nums.size - 1 downTo 0) {
            if (stack.isEmpty()) {
                out[i] = -1
            } else {
                while (stack.isNotEmpty() && stack.peek() <= nums[i])
                    stack.pop()
                out[i] = if(stack.isNotEmpty()){
                     stack.peek()
                }else{
                     -1
                }

            }
            stack.push(nums[i])
        }
        return out
    }
}