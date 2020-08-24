class LeetCode_130 {
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty() && board[0].isEmpty())
            return

        for (j in board[0].indices) {
            if (board[0][j] == 'O')
                dfs(0, j, board)
        }
        for (j in board.indices) {
            if (board[j][0] == 'O')
                dfs(j, 0, board)
        }
        for (j in board.indices) {
            if (board[j][board[0].size - 1] == 'O')
                dfs(j, board[0].size - 1, board)
        }
        for (j in board[0].indices) {
            if (board[board.size - 1][j] == 'O')
                dfs(board.size - 1, j, board)
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] != 'N')
                    board[i][j] = 'X'
            }
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == 'N')
                    board[i][j] = 'O'
            }
        }
    }

    private fun dfs(i: Int, j: Int, board: Array<CharArray>) {
        if (board[i][j] == 'O')
            board[i][j] = 'N'

        //left
        if (j - 1 >= 0 && board[i][j-1] == 'O') {
            dfs(i , j-1, board)
        }

        //right
        if (j + 1 < board[0].size && board[i][j+1] == 'O') {
            dfs(i, j+1, board)
        }

        //top
        if (i - 1 >= 0 && board[i-1][j] == 'O') {
            dfs(i-1, j, board)
        }

        //bottom
        if (i + 1 < board.size && board[i+1][j] == 'O') {
            dfs(i+1, j, board)
        }
    }
}

