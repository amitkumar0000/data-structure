package dynamicprogramming

class DynamicProgrammingMain {
     enum class METHODNAME {
         LCS, LIS
     }
    val methodName = METHODNAME.LIS

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
}