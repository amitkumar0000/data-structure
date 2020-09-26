package array

import java.util.Stack

class StockSpan {
    fun stockSpan(nums: IntArray): IntArray {
        if (nums.isEmpty()) return intArrayOf()
        var stack = Stack<Pair<Int, Int>>()
        var out = IntArray(nums.size)

        for (i in nums.indices) {
            var count = 1
            while (stack.isNotEmpty() && stack.peek().first <= nums[i]) {
                count += stack.pop().second
            }
            out[i] = count
            stack.push(Pair(nums[i], count))
        }
        return out
    }

    fun stockSpanNLE(nums: IntArray): IntArray {
        if (nums.isEmpty()) return intArrayOf()
        var stack = Stack<Pair<Int, Int>>()
        var out = IntArray(nums.size) {-1}
        for (i in nums.indices) {
            while(stack.isNotEmpty() && stack.peek().first <= nums[i]){
                stack.pop()
            }
            if(stack.isNotEmpty()){
                out[i] = stack.peek().second
            }
            stack.push(Pair(nums[i], i))
        }
        for(i in nums.indices){
            out[i] = i - out[i]
        }
        return out
    }
}

