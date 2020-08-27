package dynamicprogramming

/***
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 * A Palindrome String is one that reads the same backward as well as forward.
 */

class MinimumInsertionToPalindrome {
    fun minInsertions(s: String): Int {
        return s.length - lcs(s, s.reversed())
    }

    private fun lcs(t1: String, t2: String): Int {
        var dp = Array(t1.length + 1) {IntArray(t2.length + 1) { 0 } }

        for(i in 1 until dp.size) {
            for(j in 1 until dp[i].size) {
                dp[i][j] = if(t1[i - 1] == t2[j - 1]){
                    1 + dp[i - 1][j - 1]
                }else {
                    Math.max(dp[i -1][j], dp[i][j - 1])
                }
            }
        }
        return dp[t1.length][t2.length]
    }
}