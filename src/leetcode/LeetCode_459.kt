package leetcode

import java.lang.StringBuilder

class LeetCode_459 {
    fun repeatedSubstringPattern(s: String): Boolean {
        if(s.isEmpty()) return true
        val rep = StringBuilder()
        rep.append(s[0])

        var i = 1
        while(i < s.length) {

            if(s[i] == rep[0]){
                var j = i

               outer@ while(j + rep.length <= s.length) {
                    for(i in rep.indices){
                        if(rep[i] != s[j + i]) {
                            break@outer
                        }
                    }
                   j += rep.length
                }

                if(j == s.length)
                    return true
            }
            rep.append(s[i++])
        }

        return false
    }

    fun repeatedSubstringPattern_(s: String): Boolean {
        var n = s.length

        for(i in n/2 downTo 0){
            if(n%i == 0 && s.substring(0,i).repeat(n/i) == s)
                return true
        }
        return false
    }
}