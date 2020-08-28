package dynamicprogramming

/**
 * Longest Common SubString
 */

class LongestCommonSubString {

    fun longestCommonSubStringTopDown(text1: String, text2: String): Int {
        return lcsTopDown(text1, text2, 0, 0, 0, Array(text1.length) { IntArray(text2.length) { -1 } })
    }

    fun lcsubstringRecursion(text1: String, text2: String): Int {
        return lcsubString_recursively(text1, text2, text1.length, text2.length, 0)
    }

    /**
     * Recursion
     */
    private fun lcsRecursion(text1: String, text2: String, n1: Int, n2: Int, len: Int): Int {
        if (n1 >= text1.length || n2 >= text2.length)
            return len
        var count = len
        if (text1[n1] == text2[n2]) {
            count = lcsRecursion(text1, text2, n1 + 1, n2 + 1, len + 1)
        }
        return Math.max(
            count, Math.max(
                lcsRecursion(text1, text2, n1 + 1, n2, 0),
                lcsRecursion(text1, text2, n1, n2 + 1, 0)
            )
        )
    }

    fun lcsubString_recursively(str1: String, str2: String, m: Int, n: Int,len: Int): Int{
        if(m == 0 || n == 0)
            return len
        var count = len
        if(str1[m-1] == str2[n-1]){
            count = lcsubString_recursively(str1,str2,m-1,n-1,len+1)
        }
        return  Math.max(count,Math.max(lcsubString_recursively(str1,str2,m-1,n,0),
            lcsubString_recursively(str1,str2,m,n-1,0)))
    }

    /**
     * Memorization Top Down
     */
    private fun lcsTopDown(text1: String, text2: String, n1: Int, n2: Int, len: Int, dp: Array<IntArray>): Int {
        if (n1 >= text1.length || n2 == text2.length)
            return len

        if (dp[n1][n2] != -1)
            return dp[n1][n2]
        var count = len
        if (text1[n1] == text2[n2]) {
            count = lcsTopDown(text1, text2, n1 + 1, n2 + 1, len + 1, dp)
        }
        return Math.max(
            count, Math.max(
                lcsTopDown(text1, text2, n1, n2 + 1, 0, dp),
                lcsTopDown(text1, text2, n1 + 1, n2, 0, dp)
            )
        )

    }

    /**
     * Bottom up
     */
    fun lcsBottomUp(text1: String, text2: String): Int {
        var max = Int.MIN_VALUE
        var dp = Array(text1.length + 1) { IntArray(text2.length + 1) { 0 } }
        for (i in 1 until dp.size) {
            for (j in 1 until dp[i].size) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                    max = Math.max(max, dp[i][j])
                } else {
                    dp[i][j] = 0
                }
            }
        }
        return max
    }
}