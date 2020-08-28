package leetcode

/***
 * https://leetcode.com/problems/zigzag-conversion/
 */
class LeetCode_6 {
    fun convert(s: String, numRows: Int): String {
        var mat = Array(numRows){CharArray(s.length){' '} }

        var i = 0
        var j = 0

        var k = 0
        while(k < s.length) {
            while(i < numRows && k < s.length){
                mat[i++][j] = s[k++]
            }
            if(i != 1)
                i -=  1
            while(--i >= 0 && k < s.length){
                mat[i][++j] = s[k++]
            }
            i += 2
        }

        var res = java.lang.StringBuilder()
        for(i in 0 until numRows){
            for(j in mat[i].indices){
                if(mat[i][j] != ' ')
                    res.append(mat[i][j])
            }
        }
        return res.toString()
    }
}