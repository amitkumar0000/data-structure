package dynamicprogramming

/**
 * Largest contiguous sum
 */
class LongestContigousSum {
    var DEBUG = false
    // naive
    fun largestContiguousSum(nums: IntArray): Int {
        var max_sum = 0
        var max_till_now = 0

        var sI = 0
        var eI = 0

        for(i in nums.indices){
            max_till_now += nums[i]

            if(max_till_now > max_sum) {
                max_sum = max_till_now
                eI = i
            }

            max_sum = Math.max(max_sum, max_till_now)
            if(max_till_now < 0) {
                max_till_now = 0
                sI = i + 1
            }
        }
        if(DEBUG)
             println("LCS SI $sI EI $eI")
        return max_sum
    }

    // DP
    fun longContSum(nums: IntArray): Int{
        var cur_sum = nums[0]
        var max_sum = nums[0]

        for(i in 1 until nums.size ){
            cur_sum = Math.max(nums[i], cur_sum + nums[i])
            max_sum = Math.max(max_sum, cur_sum)
        }

        return max_sum
    }
}