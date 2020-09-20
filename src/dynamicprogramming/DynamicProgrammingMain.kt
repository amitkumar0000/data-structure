package dynamicprogramming

class DynamicProgrammingMain {
     enum class METHODNAME {
         LCS,
         LIS,
         LCSubString,
         LPS,
         KADANE,
         MAXCOIN
     }
    val methodName = METHODNAME.MAXCOIN

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println("==== Dynamic programming ====")
            val dp = DynamicProgrammingMain()


            when(dp.methodName) {
                METHODNAME.LCS ->
                    dp.longestCommonSubSequence()
                METHODNAME.LIS ->
                    dp.longestIncreasingSubSequence()
                METHODNAME.LCSubString ->
                    dp.longestCommonSubString()
                METHODNAME.LPS ->
                    dp.longestPalindromeSubString()
                METHODNAME.KADANE ->
                    dp.kadaneAlgorithm()
                METHODNAME.MAXCOIN ->
                    dp.maxCoin()
            }
        }
    }

    // LCS
    private fun longestCommonSubSequence() {
        val lcs = LongestCommonSubSequence()
        println("LCS:- ${lcs.lcsRecursion(text1 = "abcde", text2 = "ace")}")
        println("LCS:- ${lcs.lcsTopDown(text1 = "abcde", text2 = "ace")}")
        println("LCS:- ${lcs.lcsBottomUp(text1 = "abcde", text2 = "ace")}")
    }

    // LIS
    private fun longestIncreasingSubSequence() {
        val lis = LongestIncreasingSubSequence()
        println("LIS:- ${lis.LIS(intArrayOf(2,5,1,8,3))}")
        println("LIS:- ${lis.LIS(intArrayOf(0))}")
    }

    //LCSubString
    private fun longestCommonSubString() {
        val lcs = LongestCommonSubString()
        println("lCSubString:- ${lcs.lcsubstringRecursion("bacbabad","bacbad")}")
        println("lCSubString:- ${lcs.lcsubstringRecursion("babad","cbad")}")
        println("lCSubString:- ${lcs.lcsubstringRecursion("abcde","ababcde")}")
    }

    //LPS
    private fun longestPalindromeSubString() {
        val lps = LongestPalindromeSubString()
        println("longest palindrome substring: ${lps.longestPalindrome("aacdefcaa")}")
    }

    //Longest Contiguous sum
    private fun kadaneAlgorithm() {
        val lcs = LongestContigousSum()
        println("LCS:- ${lcs.largestContiguousSum(intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3))}")
        println("LCS:- ${lcs.largestContiguousSum(intArrayOf(-8, -4, -1, -3, -2, -1, -5, -3))}")

        var lcsDp = LongestContigousSum()
        println("LCS DP :- ${lcsDp.longContSum(intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3))}")
        println("LCS DP :- ${lcsDp.longContSum(intArrayOf(-8, -4, -1, -3, -2, -1, -5, -3))}")
    }

    //Maximum Coins in grid
    private fun maxCoin() {
        val mc = MaximumCoins()
        println("max coins : ${mc.maxCoinsDP(arrayOf(
                intArrayOf(0,3,1,1), 
                intArrayOf(2,0,0,14),
                intArrayOf(1,5,3,1)
        ))}")

        println("max coins : ${mc.maxCoinsDP(arrayOf(intArrayOf(1,1), intArrayOf(2,4)))}")
    }
}