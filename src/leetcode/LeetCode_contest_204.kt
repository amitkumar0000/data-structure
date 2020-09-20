package leetcode

import java.lang.StringBuilder

class LeetCode_contest_204  {
    fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
        if(arr.isEmpty() && m == 0 && k ==0)
            return true
        for(p in arr.indices) {
            var i = p
            var prevKey = ""
            var count = 0
            while(i <= arr.size - m) {
                val key = StringBuilder()
                for (j in i until m + i) {
                    if (j < arr.size)
                        key.append(arr[j])
                }

                if (key.toString() == prevKey) {
                    count++
                } else {
                    count = 1
                }

                prevKey = key.toString()
                if (count >= k)
                    return true
                i += m
            }
        }
        return false
    }

    fun getMaxLen(nums: IntArray): Int {
        TODO()
    }
}