package leetcode

/***
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
 */
class LeetCode_1513 {
    fun numSub(s: String): Int {
        var map = HashMap<Int,Int>()

        var len = 0
        var max = 0
        for(i in s.indices) {
            if(s[i] == '1') {
                len++
            }else {
                if(len > 0)
                    map[len] = map.getOrDefault(len, 0) + 1
                max = Math.max(max, len)
                len = 0
            }
        }
        if(len > 0)
            map[len] = map.getOrDefault(len, 0) + 1
        max = Math.max(max, len)
        var lookup = IntArray(max)
        if(lookup.size > 0)
            lookup[0] = 1
        for(i in 1 until lookup.size){
            lookup[i] = lookup[i-1] + i + 1
        }

        var count = 0
        map.forEach {
            count += lookup[it.key - 1] * it.value
        }

        return (count % (Math.pow(10.0,9.0) + 7)).toInt()

    }
}