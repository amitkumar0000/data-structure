package array

import java.util.*

class MinStackSpace {
    val stack = Stack<Int>()
    val minStack = Stack<Int>()

    fun minStack(nums: IntArray) {
        for(i in nums.indices){
            stack.push(nums[i])
            if(minStack.isNotEmpty() ){
                if( nums[i] < minStack.peek())
                 minStack.push(nums[i])
            }else {
                minStack.push(nums[i])
            }
        }
    }

    fun getMin(): Int {
        return if(minStack.isNotEmpty())
            minStack.peek()
        else
            -1
    }

    fun pop() {
        val num = stack.pop()
        if(minStack.isNotEmpty() && num == minStack.peek())
            minStack.pop()
    }
}