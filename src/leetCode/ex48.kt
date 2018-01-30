package leetCode

fun rotate(matrix: Array<IntArray>): Unit {
    val row = matrix.size
    val col = matrix[0].size
    //副对角线对称
    for (r in 0 until row) {
        for (c in r until col) {
            val temp = matrix[r][c]
            matrix[r][c] = matrix[c][r]
            matrix[c][r] = temp
        }
    }
    for (r in 0 until row ) {
        for (c in 0 until col/2) {
            val temp = matrix[r][c]
            matrix[r][c] = matrix[r][col-1-c]
            matrix[r][col-1-c] = temp
        }
    }
}

fun main(args: Array<String>) {
    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)).apply {
        rotate(this)
    }.forEach{
        println(it.toSet())
    }
}

