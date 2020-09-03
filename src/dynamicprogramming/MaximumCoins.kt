package dynamicprogramming

/**
 * You are given a 2-d matrix where each cell represents number of coins in that cell.
 * Assuming we start at matrix[0][0], and can only move right or down,
 * find the maximum number of coins you can collect by the bottom right corner.

        For example, in this matrix

        0 3 1 1
        2 0 0 4
        1 5 3 1

        The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

 */
class MaximumCoins {
    fun maxCoins(matrix: Array<IntArray>): Int{
        return dfs(matrix, 0, 0)
    }

    // Recursion
    private fun dfs(matrix: Array<IntArray>, i: Int, j: Int): Int{
        if(i >= matrix.size || j >= matrix[i].size)
            return 0
        if(i == matrix.size - 1 && j == matrix[i].size - 1)
            return matrix[i][j]

        return Math.max(matrix[i][j] + dfs(matrix, i+1, j), matrix[i][j] + dfs(matrix, i, j+1))
    }

    fun maxCoinsTD(matrix: Array<IntArray>): Int {
        if(matrix.isEmpty()) return 0
        val dp = Array(matrix.size +1){IntArray(matrix[0].size + 1){-1} }

        return dfs(matrix, 0, 0, dp)
    }

    //Top down
    private fun dfs(matrix: Array<IntArray>, i: Int, j: Int, dp: Array<IntArray>): Int{
        if(i >= matrix.size || j >= matrix[i].size)
            return 0
        if(i == matrix.size - 1 && j == matrix[i].size - 1)
            return matrix[i][j]

        if(dp[i][j] != -1)
            return dp[i][j]

        dp[i][j] = Math.max(matrix[i][j] + dfs(matrix, i+1, j, dp), matrix[i][j] + dfs(matrix, i, j+1, dp))

        return dp[i][j]
    }

    //Bottom Up
     fun maxCoinsDP(matrix: Array<IntArray>): Int{
        if(matrix.isEmpty()) return 0
        val dp = Array(matrix.size){IntArray(matrix[0].size)}
        dp[0][0] = matrix[0][0]
        for(i in 1 until matrix[0].size){
            dp[0][i] = matrix[0][i] + dp[0][i-1]
        }
        for(i in 1 until matrix.size){
            dp[i][0] = matrix[i][0] + dp[i-1][0]
        }

        for(i in 1 until matrix.size){
            for(j in 1 until matrix[i].size){
                dp[i][j] = matrix[i][j] + Math.max(dp[i-1][j], dp[i][j-1])
            }
        }
        return dp[matrix.size - 1][matrix[0].size - 1]
    }
}