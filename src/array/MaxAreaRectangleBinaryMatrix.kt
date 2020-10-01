package array

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
class MaxAreaRectangleBinaryMatrix {

    fun maxAreaBinaryMatrix(mat: Array<CharArray>): Int{
        if(mat.isEmpty()) return 0
        val matrix = Array(mat.size){IntArray(mat[0].size)}

        for(i in mat.indices){
            for(j in mat[i].indices){
                matrix[i][j] = mat[i][j] - '0'
            }
        }

        return maxRectBinaryMatrix(matrix)

    }

    fun maxRectBinaryMatrix(matrix: Array<IntArray>): Int{
        if(matrix.isEmpty()) return 0
        for(i in 1 until matrix.size){
            for(j in matrix[i].indices){
                if(matrix[i][j] !=0 )
                     matrix[i][j] += matrix[i-1][j]
            }
        }

        var max = 0
        val mAreaHist = MaxRecAreaHistogram()
        for(i in matrix.indices){
            val oneDArray = IntArray(matrix[i].size){0}
            for(j in matrix[i].indices){
                oneDArray[j] = matrix[i][j]
            }
            max = Math.max(max, mAreaHist.maxAreaHistogram(oneDArray))
        }

        return max
    }
}