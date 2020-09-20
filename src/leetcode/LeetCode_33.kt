package leetcode

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 33. Search in Rotated Sorted Array
 */
class LeetCode_33 {
    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) return -1
        var ri = getRotateIndex(nums)
        var l:Int = 0
        var r:Int = 0

        if(target >= nums[0] && ri-1 >= 0 && target <= nums[ri - 1]){
            l = 0
            r = ri - 1
        }else if(target >= nums[ri] && target <= nums[nums.size - 1]){
            l = ri
            r = nums.size - 1
        }

        var mid = 0
        while(l <= r){
            mid = l + (r - l)/2
            if(nums[mid] == target)
                return mid
            if(nums[mid] > target)
                r = mid - 1
            else
                l = mid + 1
        }
        return -1
    }

    private fun getRotateIndex(nums: IntArray): Int {
        var mid  = 0
        var l = 0
        var r = nums.size - 1
        while(l <= r){
            mid = l + (r - l)/2

            if(mid + 1 >= nums.size)
                return mid

            if(nums[mid] > nums[mid + 1])
                return mid + 1
            if(nums[l] > nums[mid]){
                r = mid - 1
            }else {
                l = mid + 1
            }
        }
        return mid
    }


}