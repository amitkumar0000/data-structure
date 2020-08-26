package dynamicprogramming

class LongestCommonSubSequence {
    fun lcsRecursion(text1: String, text2: String): Int {
        return lcsRecursion(text1, text2, text1.length , text2.length)
    }

    /**
     * Using recursion
     */
    private fun lcsRecursion(t1: String, t2: String, n1: Int, n2: Int): Int{
        if(n1 == 0 || n2 == 0)
            return 0
        return if(t1[n1-1] == t2[n2-1]) {
            1 + lcsRecursion(t1, t2, n1 - 1, n2 - 1)
        }else
            lcsRecursion(t1, t2, n1 - 1, n2).coerceAtLeast(lcsRecursion(t1, t2, n1, n2 - 1))
    }

    /**
     *  Top Down
     */
    fun lcsTopDown(text1: String, text2: String): Int{
        return lcsTopDown(
            text1, text2,
            text1.length,
            text2.length,
            Array(text1.length + 1){ IntArray(text2.length + 1){-1}}
        )
    }

    private fun lcsTopDown(text1: String, text2: String, n1: Int, n2: Int, dp: Array<IntArray>): Int{
        if(n1 == 0 || n2 == 0)
            return 0

        if(dp[n1][n2] != -1)
            return dp[n1][n2]

        dp[n1][n2] = if(text1[n1 - 1] ==  text2[n2 - 1]){
            1 + lcsTopDown(text1, text2, n1 - 1, n2 - 1, dp)
        } else {
            Math.max(lcsTopDown(text1, text2, n1 - 1, n2, dp),
                lcsTopDown(text1, text2, n1, n2 - 1, dp))
        }

        return dp[n1][n2]
    }

    /**
     * Bottom up
     */
    fun lcsBottomUp(text1: String, text2: String): Int{
        var dp = Array(text1.length + 1){IntArray(text2.length + 1){0}}

        for(i in 1 until dp.size) {
            for(j in 1 until dp[i].size) {
                dp[i][j] = if(text1[i - 1] == text2[j - 1]){
                    1 + dp[i - 1][j - 1]
                }else {
                    Math.max(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[text1.length][text2.length]
    }
}