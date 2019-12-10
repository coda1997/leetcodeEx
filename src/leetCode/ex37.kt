package leetCode

fun solveSudoku(board: Array<CharArray>) {
    if (board.isEmpty()) return
    dfs(board)

}

private fun dfs(board: Array<CharArray>): Boolean {
    for (row in board.indices) {
        for (col in board[0].indices) {
            if (board[row][col] == '.') {
                for (it in '1' .. '9') {
                    if (isValidSudoku(board, it, row, col)) {
                        board[row][col] = it
                        if (dfs(board)) {
                            return true
                        } else {
                            board[row][col] = '.'
                        }
                    }
                }
                return false
            }
        }
    }
    return true
}

private fun isValidSudoku(board: Array<CharArray>, num: Char, r: Int, c: Int): Boolean {
    (0 until 9).forEach {
        if (board[r][it] == num || board[it][c] == num) {
            return false
        }
    }
    val rr = r / 3 * 3
    val cc = c / 3 * 3
    (rr until rr + 3).forEach { row ->
        (cc until cc + 3).forEach { col ->
            if (board[row][col] == num) {
                return false
            }
        }
    }
    return true
}

fun main(args: Array<String>) {
    ('1' until '9').forEach { println(it) }
}