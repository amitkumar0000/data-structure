package dynamicprogramming

/**
 * Longest Common SubString
 */

class LongestCommonSubString {
    var max = Int.MIN_VALUE

    fun longestCommonSubStringTopDown(text1: String, text2: String): Int {
        max = Int.MIN_VALUE
        lcsTopDown(text1, text2, 0, 0, 0, Array(text1.length){IntArray(text2.length){-1}})
        return max
    }

    fun lcsubstringRecursion(text1: String, text2: String): Int{
        max = Int.MIN_VALUE
        lcsRecursion(text1, text2, 0, 0, 0)
        return max
    }

    /**
     * Recursion
     */
    private fun lcsRecursion(text1: String, text2: String, n1: Int, n2: Int, len: Int): Int {
        if (n1 >= text1.length || n2 >= text2.length)
            return len
        if (text1[n1] == text2[n2]) {
            var count = lcsRecursion(text1, text2, n1+1, n2 + 1, len + 1)
            max = Math.max(max, count)
        } else {
            lcsRecursion(text1, text2, n1 + 1, n2, 0)
            lcsRecursion(text1, text2, n1, n2 + 1, 0)
        }
        return len
    }

    /**
     * Memorization Top Down
     */
    private fun lcsTopDown(text1: String, text2: String, n1: Int, n2: Int, len: Int, dp:Array<IntArray>): Int {
        if (n1 >= text1.length || n2 == text2.length)
            return len

        if(dp[n1][n2] != -1)
            return dp[n1][n2]

        if(text1[n1] == text2[n2]) {
            val len = lcsTopDown(text1, text2, n1 + 1, n2 + 1, len + 1, dp)
            max = Math.max(max, len)
        }else {
            lcsTopDown(text1, text2, n1, n2 + 1, 0, dp)
            lcsTopDown(text1, text2, n1 + 1, n2, 0, dp)
        }
        return len
    }

    /**
     * Bottom up
     */
     fun lcsBottomUp(text1: String, text2: String): Int{
        var max = Int.MIN_VALUE
        var dp = Array(text1.length + 1){IntArray(text2.length + 1){0} }
        for(i in 1 until dp.size) {
            for(j in 1 until dp[i].size){
                if(text1[i - 1] == text2[j - 1]){
                    dp[i][j] = 1 + dp[i-1][j-1]
                    max = Math.max(max, dp[i][j])
                }else {
                    dp[i][j] = 0
                }
            }
        }
        return max
    }
}