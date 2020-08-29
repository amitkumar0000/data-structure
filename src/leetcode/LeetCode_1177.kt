package leetcode

/**
 * https://leetcode.com/problems/can-make-palindrome-from-substring/
 */
class LeetCode_1177 {
    /**
     * Logic:- As string length and queries size can be  10^5.
     * Each time calculating makePalindrome on substring can be costly affair.
     * Use the Prefix Sum to store count of character at specific index
     * and the segment tree or range query concept to get each character count at
     * specific range
     *
     *  Prefix sum e.g
     *  arr = [1,0,1,2,3]
     *  prefixSum = [1,1,2,4,6]   pre-calculation
     *
     *  sum(range(1,3)) = sum[3]-sum[1-1] = 4 - 1 = 3
     */
    fun canMakePaliQueries(s: String, queries: Array<IntArray>): BooleanArray {
        var prefixSum = Array<HashMap<Char, Int>>(s.length){ HashMap() }

        var tMap = HashMap<Char, Int>()
        for(i in s.indices) {
            tMap[s[i]] = tMap.getOrDefault(s[i], 0) + 1
            prefixSum[i] = HashMap(tMap)
        }

        var result = BooleanArray(queries.size){ false }
        var index = 0
        queries.forEach {
            result[index++] = it[2] >= makePalindrome(prefixSum, it[0], it[1])
        }
        return result
    }

    private fun makePalindrome(prefixSum: Array<HashMap<Char, Int>>, s: Int, e: Int): Int{
        val eMap = prefixSum[e]
        var sMap = HashMap<Char, Int>()
        if(s-1> 0) {
            sMap = prefixSum[s - 1]
        }

        var rMap = HashMap<Char, Int>()

        eMap.forEach {
            rMap[it.key] = it.value - sMap.getOrDefault(it.key, 0)
        }

        var oddCount = 0
        rMap.forEach {
            if(it.value % 2 != 0)
                oddCount ++
        }

        return oddCount/2
    }
}