package ds450.arrays

class ReverseArray {
    fun reverseRecursive(nums: IntArray): IntArray {
        return reverseRecursive(nums, 0, nums.size - 1)
    }

    fun reverseRecursive(nums: IntArray, left: Int, right: Int): IntArray {
        if (left > right)
            return nums
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        return reverseRecursive(nums, left + 1, right - 1)
    }

    fun minMax(nums: IntArray): Pair<Int, Int> {
        if (nums.isEmpty()) return Pair(0,0)

        var max = nums[0]
        var min = nums[0]
        for (i in 1 until nums.size) {
            max = Math.max(max, nums[i])
            min = Math.min(min, nums[i])
        }
        return Pair(max, min)
    }
}