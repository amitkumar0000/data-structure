package dynamicprogramming

class DynamicProgrammingMain {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println("==== Dynamic programming")
            val dp = DynamicProgrammingMain()
            dp.longestCommonSubSequence()
        }
    }

    private fun longestCommonSubSequence() {
        val lcs = LongestCommonSubSequence()
        println("LCS:- ${lcs.lcsRecursion(text1 = "abcde", text2 = "ace")}")
        println("LCS:- ${lcs.lcsTopDown(text1 = "abcde", text2 = "ace")}")
        println("LCS:- ${lcs.lcsBottomUp(text1 = "abcde", text2 = "ace")}")
    }
}