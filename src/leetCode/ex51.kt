package leetCode

fun solveNQueens(n: Int): List<List<String>> {
    val temp = mutableListOf<IntArray>()
    dfs(IntArray(n) { -1 }, temp)
    val res = mutableListOf<List<String>>()
    val s = mutableListOf<String>()
    (0 until n).forEach { item1 ->
        s.add(buildString {
            (0 until n).forEach { item ->
                if (item1 == item) {
                    append('Q')
                } else {
                    append('.')
                }
            }
        })
    }
    for (t in temp) {
        res.add(mutableListOf<String>().apply {
            t.forEach {
                add(s[it])
            }
        })
    }
    return res
}

private fun dfs(board: IntArray, res: MutableList<IntArray>): Boolean {
    (0 until board.size).forEach { col ->
        if (board[col] == -1) {
            (0 until board.size).forEach { num ->
                if (isValid(board, num)) {
                    board[col] = num
                    if (!dfs(board, res)) {
                        board[col] = -1
                    }
                }
            }
            return false
        }
    }
    res.add(board.clone())
    board[board.size-1]=-1
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

fun main(args: Array<String>) {
    solveNQueens(5).apply { println(size) }.forEach { item ->
        item.forEach { println(it) }
        println()
    }
}
