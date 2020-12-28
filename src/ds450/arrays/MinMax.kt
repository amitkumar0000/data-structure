package ds450.arrays

import java.util.*

class MinMax {
    fun minMax(nums: IntArray): Pair<Int, Int> {
        if(nums.isEmpty()) return Pair(0,0)
        var max: Int
        var min: Int
        var index = 0
        if(nums.size % 2 == 0) {
            if(nums[index] > nums[index + 1]) {
                max = nums[index]
                min = nums[index + 1]
            } else {
                max = nums[index + 1]
                min = nums[index]
            }
            index += 2
        } else {
            max = nums[index]
            min = nums[index]
            index += 1
        }

        while(index < nums.size - 1) {
            if(nums[index] > nums[index + 1]) {
                max = Math.max(nums[index], max)
                min = Math.min(nums[index + 1], min)
            } else {
                max = Math.max(nums[index + 1], max)
                min = Math.min(nums[index], min)
            }
            index += 2
        }
        return Pair(max, min)
    }
}