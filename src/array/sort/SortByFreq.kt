package array.sort

import kotlin.collections.HashMap


class SortByFreq {
    fun sortByFreq(nums: IntArray): IntArray {
        var hMap = HashMap<Int, Pair>()
        for (i in nums.indices) {
            val pair = hMap.getOrDefault(nums[i], Pair(index = i))
            pair.count++
            hMap[nums[i]] = pair
        }
        val result = IntArray(nums.size)
        var index = 0
        hMap.toList().sortedWith(Comparator { o1, o2 ->
            when {
                o1.second.count != o2.second.count -> o2.second.count - o1.second.count
                else -> o1.second.index - o2.second.index
            }
        }).forEach {
            for(i in 0 until it.second.count){
                result[index++] = it.first
            }
        }

        return result
    }

    data class Pair(var count: Int = 0, var index: Int = -1)
}