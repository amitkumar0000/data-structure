package array

import java.util.Stack

class MinStack {
    private val stack = Stack<Int>()
    private var min = Int.MAX_VALUE

    fun minStack(nums: IntArray){
        min = nums[0]
        stack.push(nums[0])

        for(i in 1 until nums.size) {
            if(nums[i] < min){
                stack.push(2*nums[i]-min)
                min = nums[i]
            }else {
                stack.push(nums[i])
            }
        }
    }

    fun pop() {
        if(stack.peek() < min){
            min = 2*min - stack.pop()
        }else {
            stack.pop()
        }
    }

    fun getMinV(): Int{
        return if(min == Int.MAX_VALUE)
            -1
        else
            min
    }
}