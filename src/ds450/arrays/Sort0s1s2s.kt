package ds450.arrays

class Sort0s1s2s {
    fun sort(nums: IntArray): IntArray{
        var zeroesCount = 0
        var onesCount = 0
        var twoesCount = 0

        nums.forEach{ num ->
            when(num) {
                0 -> zeroesCount++
                1 -> onesCount++
                2 -> twoesCount++
                else ->
                    throw IllegalArgumentException("Number should be in range [0,2]")
            }
        }

        var index = 0
        while(zeroesCount-- > 0)
            nums[index++] = 0
        while(onesCount-- > 0)
            nums[index++] = 1
        while(twoesCount-- > 0)
            nums[index++] = 2
        return nums
    }
}

fun Sort0s1s2s.sort0s1s2s(nums: IntArray): IntArray {
    if (nums.isEmpty()) return nums
    var left = 0
    var right = nums.size -1

    // 1st Iteration, move all 2s to right
    while(left <= right){
        if(nums[left] == 2){
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            right -= 1
        }
        left += 1
    }

    // reset left
    left = 0

    // 2nd Iteration, moves all 0s to left
    while(left <= right){
        if(nums[right] == 0){
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left += 1
        }
        right -= 1
    }
    return nums
}