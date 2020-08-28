package dynamicprogramming

class DynamicProgrammingMain {
     enum class METHODNAME {
         LCS,
         LIS,
         LCSubString,
         LPS,
     }
    val methodName = METHODNAME.LPS

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
}