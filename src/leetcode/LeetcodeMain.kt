package leetcode

import LeetCode_130

class LeetcodeMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("=== LeetCode =====")

            leetCode128()
        }

        private fun leetCode128(){
            val leetcode128 = LeetCode_128()
            println("Longest consecutive subsequence ${leetcode128.longestConsecutive(intArrayOf(100,4,200,3,2,1))}")
        }
    }
}