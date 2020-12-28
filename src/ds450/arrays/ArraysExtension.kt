package ds450.arrays

import kotlin.collections.HashSet

fun IntArray.moveNegative(): IntArray {
    val nums = this
    if(nums.isEmpty()) return nums
    var left = 0
    var right = nums.size - 1

    while(left < right) {
        // Anchor left to positive number
        while(left < right && nums[left] < 0 ) {
            left += 1
        }

        // Anchor right to negative number
        while(left < right && nums[right] >= 0) {
            right -= 1
        }

        if (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left += 1
            right -= 1
        }
    }
    return nums
}

fun IntArray.moveNegativeNum(): IntArray {
    var nums = this

    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        if(nums[left] < 0 && nums[right] >= 0) {
            left += 1
            right -= 1
        } else if(nums[left] >= 0 && nums[right] < 0 ) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left += 1
            right -= 1
        } else if(nums[left] < 0 && nums[right] < 0) {
            left += 1
        } else {
            right -= 1
        }
    }
    return nums
}

fun IntArray.moveNeg(): IntArray {
    var j = 0

    for(i in this.indices) {
        if(this[i] < 0) {
            if (i != j) {
                val temp = this[i]
                this[i] = this[j]
                this[j] = temp
            }
            j++
        }
    }
    return this
}

fun IntArray.union(nums: IntArray): IntArray {
    var result = HashSet<Int>()
    for(i in this.indices){
        result.add(this[i])
    }
    for(i in nums.indices) {
        result.add(nums[i])
    }

    return result.toIntArray()
}

fun IntArray.intersection(nums: IntArray): IntArray {
    val set2 = nums.toHashSet()

    return  this.toHashSet().asSequence().filter {
            set2.contains(it)
        }.toList().toIntArray()
}

fun IntArray.cycleByOne(): IntArray {
    reverse(this, 0, this.size - 2)
    reverse(this, 0, this.size - 1)
    return this
}

private fun reverse(nums: IntArray, left: Int, right: Int) {
    var start = left
    var end = right
    while(start < end) {
        val temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start += 1
        end -= 1
    }
}

fun IntArray.maxSubArraySum(): Int {
    if (this.isEmpty())
        throw IllegalArgumentException("Array can't be empty")
    var sumTillNow = this[0]
    var max = this[0]

    for(index in 1 until this.size) {

        sumTillNow = Math.max(sumTillNow+this[index], this[index])

        max = Math.max(max, Math.max(sumTillNow, this[index]))
    }

    return max
}

fun IntArray.maximumHeight(k: Int): Int {
    TODO("Not implemented")
}

fun IntArray.minJump(): Int {
    if(this.isEmpty())
        throw IllegalArgumentException("Array can't be empty")
    return minJump(this,0)
}

private fun minJump(nums: IntArray, pos: Int): Int {
    if(pos >= nums.size - 1)
        return 0
    if(nums[pos] == 0)
        return Int.MAX_VALUE
    var min = Int.MAX_VALUE
    var out: Int = min

    for(i in 1..nums[pos]) {
        if(pos + i >= nums.size - 1) {
            return 1
        }
        val jump = minJump(nums, pos + i)
        if(jump != Int.MAX_VALUE)
           out = 1 + jump
        min = Math.min(min, out)
    }

    return min
}

fun IntArray.jumpGamp(): Int {
    val nums = this
    if(nums.isEmpty())
        throw IllegalArgumentException("Array can't be empty")
    var dp = IntArray(nums.size) {Int.MAX_VALUE}
    dp[0] = 0
    for(i in 1 until nums.size) {
        var min = Int.MAX_VALUE
        for(j in 0 until i) {
            if(nums[j] + j >= i) {
                min = Math.min(dp[j]+1, min)
            }
        }
        dp[i] = min
    }

    return dp[nums.size - 1]
}

fun IntArray.findClosetLargest(target: Int): Int {
    val nums = this

    var left = 0
    var right = nums.size - 1
    while(left <= right) {
        val mid = left + (right - left)/2
        if(nums[mid] > target) {
            if(mid + 1 < nums.size && nums[mid + 1] > target) {
                left = mid + 1
            }

            if(mid + 1 < nums.size && nums[mid + 1] < target)
                return nums[mid]
        }else {
            right = mid - 1
        }
    }
    throw IllegalStateException("No result found")
}

fun IntArray.mergeSort(): Int {
    val nums = this
    if(nums.isEmpty()) return 0
    return  mergeSort(nums, 0, nums.size - 1)
}

private fun mergeSort(nums: IntArray, left: Int, right: Int): Int{
    if(left >= right)
        return 0
    val mid = left + (right - left)/2
    return mergeSort(nums, left, mid) +
            mergeSort(nums, mid + 1, right) +
                merge(nums, left, mid, right)
}

private fun merge(nums: IntArray, left: Int, mid: Int, right: Int): Int{
    val out = IntArray(right - left + 1){0}

    var l = left
    var r = mid + 1
    var k = 0
    var count = 0
    while(l <= mid && r <= right) {
        if(nums[l] > nums[r]) {
            out[k++] =  nums[r++]
            count += mid - l + 1
        } else {
            out[k++] = nums[l++]
        }
    }
    while(l <= mid) {
        out[k++] = nums[l++]
    }
    while(r <= right) {
        out[k++] = nums[r++]
    }

    k = 0
    for(i in left..right) {
        nums[i] = out[k++]
    }

    return count
}

fun IntArray.reArrangeNegativePos(): IntArray{
    val nums = this
    if(nums.isEmpty())
        return nums
    val out = IntArray(nums.size)
    var p = 0
    var n = 0
    var k = 0
    while(p < nums.size && n < nums.size) {
        while(p<nums.size && nums[p] < 0)
            p++
        while(n < nums.size && nums[n] >= 0)
            n++

        if(n < nums.size)
            out[k++] = nums[n++]
        if(p < nums.size)
            out[k++] = nums[p++]
    }
    while(p < nums.size) {
        if(nums[p] < 0) {
            p++
            continue
        }
        out[k++] = nums[p++]
    }

    while(n < nums.size) {
        if(nums[n] >= 0) {
            n++
            continue
        }
        out[k++] = nums[n++]
    }

    return out
}

fun IntArray.reArrangeNegative(): IntArray{
    val nums = this
    if(nums.isEmpty()) return nums
    var j = -1
    for(i in nums.indices) {
        if(nums[i] < 0) {
            j++;
            val temp = nums[j]
            nums[j] = nums[i]
            nums[i] = temp
        }
    }
    return nums
}

fun IntArray.reArrangeNegativePositiveO1Space(): IntArray {
    val nums = this
    for(i in nums.indices) {
        if(i%2 == 0 && nums[i] >= 0) {
            var k = i + 1
            while(k < nums.size && nums[k] >= 0)
                k++
            if(k >= nums.size)
                break
            val temp = nums[k]
            for(j in k downTo i + 1){
                nums[j] = nums[j - 1]
            }
            nums[i] = temp
        } else if(i%2 != 0 && nums[i] < 0) {
            var k = i + 1
            while(k < nums.size && nums[k] < 0)
                k++
            if(k >= nums.size)
                break
            val temp = nums[k]
            for(j in k downTo i + 1){
                nums[j] = nums[j - 1]
            }
            nums[i] = temp
        }
    }

    return nums
}