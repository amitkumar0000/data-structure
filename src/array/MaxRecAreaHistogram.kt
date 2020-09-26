package array

import java.util.Stack

/***
 *  Max Rectangle in Histogram.
 *  Traverse from a point to both side to get next smaller number
 *  that will give length and value will be width
 */
class MaxRecAreaHistogram {

    fun maxAreaHistogram(nums: IntArray): Int {
        var max = 0
        val slI = nextSmallestLeft(nums)
        val srI = nextSmallestRight(nums)

        for(i in nums.indices){
            var eIndex = srI[i]
            var sIndex = slI[i]
            max = Math.max(max,((eIndex - sIndex)+1) * nums[i])
        }
        return max
    }

    private fun nextSmallestLeft(nums: IntArray): IntArray {
        if (nums.isEmpty()) return intArrayOf()
        val st = Stack<Pair<Int,Int>>()
        val out = IntArray(nums.size){-1}
        for(i in nums.indices) {
            while(st.isNotEmpty() && st.peek().first >= nums[i]){
                st.pop()
            }
            if(st.isNotEmpty()) {
                out[i] = st.peek().second
            }
            st.push(Pair(nums[i],i))
        }
        for(i in out.indices){
            out[i] += 1
        }
        return out
    }

    private fun nextSmallestRight(nums: IntArray): IntArray {
        if(nums.isEmpty()) return intArrayOf()
        val stack = Stack<Pair<Int, Int>>()
        val out= IntArray(nums.size) {nums.size}
        for(i in nums.size - 1 downTo 0){
            while(stack.isNotEmpty() && stack.peek().first >= nums[i]){
                stack.pop()
            }
            if(stack.isNotEmpty()) {
                out[i] = stack.peek().second
            }
            stack.push(Pair(nums[i],i))
        }
        for(i in out.indices) {
            out[i] -= 1
        }
        return out
    }
}