package leetcode

import java.util.Stack

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 1249. Minimum Remove to Make Valid Parentheses
 */
class LeetCode_1249 {
    fun minRemoveToMakeValid(s: String): String {
        var st1 = Stack<Char>()
        var st2 = Stack<Char>()

        for(i in s.indices) {
            if(s[i] == ')'){
                if( st2.isNotEmpty() && st2.peek() == '(') {
                    st1.push(s[i])
                    st2.pop()
                }
            } else {
                st1.push(s[i])
                if(s[i] == '(')
                    st2.push(s[i])
            }
        }

        var res = StringBuilder()
        while(st1.isNotEmpty()){

            if(st1.peek() == '(' && st2.isNotEmpty() && st2.peek() == '('){
                st1.pop()
                st2.pop()
            }else {
                res.append(st1.pop())
            }
        }

        return res.reversed().toString()
    }

}