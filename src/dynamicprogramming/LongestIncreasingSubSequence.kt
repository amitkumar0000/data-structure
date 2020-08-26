package dynamicprogramming

import java.util.*

/**
 *  Longest Increasing SubSequence
 *  LIS
 */
class LongestIncreasingSubSequence {

    fun LIS(nums: IntArray): Int{
        if(nums.isEmpty()) return 0
        var out = IntArray(nums.size){1}
        var max = 1
        for(j in 1 until nums.size){
            for(i in 0..j){
                if(nums[i] < nums[j]){
                    out[j] = Math.max(1 + out[i], out[j])
                    max = Math.max(out[j], max)
                }
            }
        }

        return max
    }
}