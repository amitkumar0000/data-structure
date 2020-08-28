package dynamicprogramming

/**
 *  https://leetcode.com/problems/longest-palindromic-substring/
 *
 *  Longest palindrome substring
 */
class LongestPalindromeSubString {
    fun longestPalindrome(s: String): String {
        var res = StringBuilder()
        var len = 0
        var max = 0

        //first pass for odd number
        for(i in s.indices) {
            var j = i - 1
            var k = i + 1
            len = 1
            var temp = StringBuilder()
            temp.append(s[i])
            while(j >= 0 && k < s.length){
                if(s[j] == s[k]){
                    len += 2
                    temp.append(s[k++])
                    temp.insert(0, s[j--])
                }else{
                    break
                }
            }
            if(len > max){
                max = len
                res = temp
            }
        }

        //second pass for even number
        for(i in 0 until s.length -  1) {
            var j = i
            var k = i + 1
            var len = 2
            var temp = StringBuilder()
            if(s[j] == s[k]){
                temp.append(s[k++])
                temp.insert(0, s[j--])
                while(j >= 0 && k < s.length) {
                    if(s[j] == s[k]){
                        len += 2
                        temp.append(s[k++])
                        temp.insert(0, s[j--])
                    }else{
                        break
                    }
                }
                if(len > max){
                    max = len
                    res = temp
                }
            }
        }

        return res.toString()
    }
}