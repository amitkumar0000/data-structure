package leetcode

import java.util.*
import kotlin.collections.HashSet

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
class LeetCode_128 {
    /***
     *  TC : O(N)
     *
     *  store in Set, remove if consecutive element find at set and increase the count
     *  Maintain max
     */
    fun longestConsecutive(nums: IntArray): Int {

        var set = HashSet<Int>()
        var max  = 0
        nums.forEach { set.add(it) }

        while(set.isNotEmpty()){
            var number = set.elementAt(0)   //TC: O(1)
            var count = 1

            var temp1 = number - 1
            var temp2 = number + 1
            set.remove(number)
            while(set.contains(temp2)){
                set.remove(temp2)              //TC: O(1)
                count++
                temp2 += 1
            }

            while (set.contains(temp1)){
                set.remove(temp1)
                count++
                temp1 -= 1
            }
            max = Math.max(max, count)
        }
        return max
    }
}