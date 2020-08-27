package dynamicprogramming

class LongestPalindromeSubSequence {
    fun longestPalindromeSubsequence(s: String): Int {
        return lcs(s, s.reversed())
    }

    private fun lcs(t1: String, t2: String): Int{
        var dp = Array(t1.length + 1){IntArray(t2.length + 1){0}}

        for(i in 1 until dp.size){
            for(j in 1 until dp[i].size){
                dp[i][j] = if(t1[i-1] == t2[j-1]){
                    1 + dp[i-1][j-1]
                }else{
                    Math.max(dp[i][j-1], dp[i-1][j])
                }
            }
        }

        return dp[t1.length][t2.length]
    }
}