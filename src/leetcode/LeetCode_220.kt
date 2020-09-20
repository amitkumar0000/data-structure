package leetcode

import java.util.*

class LeetCode_220 {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        var set = TreeSet<Long>()

        for(i in nums.indices){
            var floor = set.floor(nums[i].toLong())

            floor?.let {
                if(nums[i] - it <= t)
                    return true
            }

            set.ceiling(nums[i].toLong())?.let {
                if(it - nums[i] <= t)
                    return true
            }
            set.add(nums[i].toLong())
            if(set.size > k)
                set.remove(nums[i - k].toLong())
        }
        return false
    }
}