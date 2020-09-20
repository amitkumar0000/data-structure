package leetcode

class LeetcodeMain {
    enum class METHODNAME {
        LC6,
        LC33,
        LC56,
        LC128,
        LC202,
        LC436,
        LC459,
        LC1177,
        LC1513,
        LC1249,
        LC_C_204
    }
    val methodName = METHODNAME.LC33

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("=== LeetCode =====")
            val lc = LeetcodeMain()

            when(lc.methodName) {
                METHODNAME.LC6 ->
                    leetCode6()
                METHODNAME.LC33 ->
                    leetCode33()
                METHODNAME.LC56 ->
                    leetCode56()
                METHODNAME.LC128 ->
                    leetCode128()
                METHODNAME.LC459 ->
                    leetCode459()
                METHODNAME.LC436 ->
                    leetCode436()
                METHODNAME.LC1177 ->
                    leetCode1177()
                METHODNAME.LC1513 ->
                    leetCode1153()
                METHODNAME.LC1249 ->
                    leetCode1249()
                METHODNAME.LC_C_204 ->
                    leetCode_Contest_204_5499()
                METHODNAME.LC202 ->
                    leetCode202()
            }
        }

        private fun leetCode6() {
            val lc6 = LeetCode_6()
            println("String after conversion: ${lc6.convert("PAYPALISHIRING", 3)}")
            println("String after conversion: ${lc6.convert("AB", 1)}")
        }

        private fun leetCode33() {
            val lc33 = LeetCode_33()
            println("Target index: ${lc33.search(intArrayOf(1,3,1,1,1), 3)}")
            println("Target index: ${lc33.search(intArrayOf(4,5,1,2,3), 1)}")
            println("Target index: ${lc33.search(intArrayOf(3,5,1), 3)}")
            println("Target index: ${lc33.search(intArrayOf(1,3), 3)}")

            println("Target index: ${lc33.search(intArrayOf(5,1,3), 3)}")

            println("Target index: ${lc33.search(intArrayOf(4,5,6,7,0,1,2), 0)}")
            println("Target index: ${lc33.search(intArrayOf(4,5,6,7,0,1,2), 3)}")
        }

        private fun leetCode56() {
            val lc56 = LeetCode_56()
            lc56.merge(arrayOf(
                    intArrayOf(5,5),
                    intArrayOf(1,3),
                    intArrayOf(3,5),
                    intArrayOf(4,6),
                    intArrayOf(1,1),
                    intArrayOf(3,3),
                    intArrayOf(5,6),
                    intArrayOf(3,3),
                    intArrayOf(2,4),
                    intArrayOf(0,0)
            )).forEach {
                it.forEach { print("$it ") }
                println("")
            }
        }

        private fun leetCode128(){
            val leetcode128 = LeetCode_128()
            println("Longest consecutive subsequence ${leetcode128.longestConsecutive(intArrayOf(100,4,200,3,2,1))}")
        }

        private fun leetCode202() {
            val leetcode202 = LeetCode_220()
            println("state:  ${leetcode202.containsNearbyAlmostDuplicate(intArrayOf(-1,2,4,1), 3, 2)}")
        }

        private fun leetCode436() {
            val lc111 = LeetCode_436()
            lc111.findRightInterval(arrayOf(intArrayOf(4,5), intArrayOf(2,3), intArrayOf(1,2))).forEach {
                print("$it ")
            }
        }

        private fun leetCode459() {
            val lc459 = LeetCode_459()
            println("state:  ${lc459.repeatedSubstringPattern("abac")}")
            println("state:  ${lc459.repeatedSubstringPattern("abab")}")
            println("state:  ${lc459.repeatedSubstringPattern("aba")}")
            println("state:  ${lc459.repeatedSubstringPattern("abcabcabcabc")}")
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

        private fun leetCode1249() {
            val lc1249 = LeetCode_1249()
            println("valid string: ${lc1249.minRemoveToMakeValid("))((")}")
            println("valid string: ${lc1249.minRemoveToMakeValid("lee(t(c)o)de)")}")
        }

        private fun leetCode_Contest_204_5499() {
            val lc = LeetCode_contest_204()
            println("-- Question 1---")
            println("status:- ${lc.containsPattern(intArrayOf(), 0, 0)}")
            println("status:- ${lc.containsPattern(intArrayOf(1,2,4,4,4,4), 1, 3)}")
            println("status:- ${lc.containsPattern(intArrayOf(1,2,1,2,1,1,1,3), 2, 2)}")
            println("status:- ${lc.containsPattern(intArrayOf(1,2,1,2,1,3), 2, 3)}")
            println("status:- ${lc.containsPattern(intArrayOf(1,2,3,1,2), 2, 2)}")
            println("status:- ${lc.containsPattern(intArrayOf(2,2,2,2), 2, 3)}")

            println("-- Question 2---")
            println("max len ${lc.getMaxLen(intArrayOf(1,-2,-3,4))}")
            println("max len ${lc.getMaxLen(intArrayOf(0,1,-2,-3,-4))}")
            println("max len ${lc.getMaxLen(intArrayOf(-1,-2,-3,0,1))}")
            println("max len ${lc.getMaxLen(intArrayOf(-1,2))}")
            println("max len ${lc.getMaxLen(intArrayOf(1,2,3,5,-6,4,0,10))}")
        }
    }
}