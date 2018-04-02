package leetCode
class A{
    var num = 0

    fun totalNQueens(n: Int): Int {
        dfs(IntArray(n){-1})
        return num
    }
    private fun dfs(board: IntArray): Boolean {
        (0 until board.size).forEach { col ->
            if (board[col] == -1) {
                (0 until board.size).forEach { num ->
                    if (isValid(board, num)) {
                        board[col] = num
                        if (!dfs(board)) {
                            board[col] = -1
                        }
                    }
                }
                return false
            }
        }

        board[board.size-1]=-1
        num++
        return true
    }

    private fun isValid(board: IntArray, num: Int): Boolean {
        if (board.any { it == num }){
            return false
        }
        var c = 0
        while (board[c]!=-1){
            c++
        }
        if (c==0){
            return true
        }
        (0 until c).forEach {
            if (board[it]==num+c-it||board[it]==num-(c-it)){
                return false
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    A().totalNQueens(5).apply { println(this) }
}