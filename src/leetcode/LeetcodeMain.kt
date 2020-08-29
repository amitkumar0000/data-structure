package leetcode

class LeetcodeMain {
    enum class METHODNAME {
        LC6,
        LC128,
        LC436,
        LC1177,
        LC1513
    }
    val methodName = METHODNAME.LC1513

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("=== LeetCode =====")
            val lc = LeetcodeMain()

            when(lc.methodName) {
                METHODNAME.LC6 ->
                    leetCode6()
                LeetcodeMain.METHODNAME.LC128 ->
                    leetCode128()
                LeetcodeMain.METHODNAME.LC436 ->
                    leetCode436()
                METHODNAME.LC1177 ->
                    leetCode1177()
                METHODNAME.LC1513 ->
                    leetCode1153()
            }
        }

        private fun leetCode6() {
            val lc6 = LeetCode_6()
            println("String after conversion: ${lc6.convert("PAYPALISHIRING", 3)}")
            println("String after conversion: ${lc6.convert("AB", 1)}")
        }

        private fun leetCode128(){
            val leetcode128 = LeetCode_128()
            println("Longest consecutive subsequence ${leetcode128.longestConsecutive(intArrayOf(100,4,200,3,2,1))}")
        }

        private fun leetCode436() {
            val lc111 = LeetCode_436()
            lc111.findRightInterval(arrayOf(intArrayOf(4,5), intArrayOf(2,3), intArrayOf(1,2))).forEach {
                print("$it ")
            }
        }

        private fun leetCode1177() {
            val lc1177 = LeetCode_1177()
            lc1177.canMakePaliQueries("abbccc", arrayOf(intArrayOf(0, 5, 1))).forEach {
                print("$it ")
            }

            lc1177.canMakePaliQueries("urgrihwbkjsrybm", arrayOf(intArrayOf(1,13,5))).forEach {
                print("$it ")
            }
            println()
        }

        private fun leetCode1153() {
            val lc1153 = LeetCode_1513()
            println("No of 1s : ${lc1153.numSub("11111111")}")
        }
    }
}