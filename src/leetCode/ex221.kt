package leetCode

import kotlin.math.min

fun maximalSquare(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty()) {
        return 0
    }
    val t = List(matrix.size) { IntArray(matrix[0].size) { 0 } }
    //init t
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            t[i][j] = matrix[i][j] - '0'
        }
    }
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (t[i][j]==0){
                continue
            }
            t[i][j] = min(t[i - 1][j - 1], min(t[i][j - 1], t[i - 1][j])) + 1
        }
    }
    val root = t.map { it.max() }.maxBy { it ?: 0 } ?: 0
    return root*root
}

