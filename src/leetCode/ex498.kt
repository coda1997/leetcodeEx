package leetCode

fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    val iMax = matrix.size
    if (iMax == 0) {
        return intArrayOf()
    }
    val jMax = matrix[0].size
    val res = IntArray(iMax * jMax) { 0 }
    var temp = 0
    var factor = -1
    var i = 0
    var j = 0
    while (i <= iMax && j <= jMax) {
        res[temp++] = matrix[i][j]
        if (i == iMax - 1 && j == jMax - 1) {
            break
        }
        i += factor
        j -= factor
        if (j == jMax) {
            j = jMax - 1
            i += 2
            factor *= -1
        } else if (i == -1) {
            i = 0
            factor *= -1
        } else if (i == iMax) {
            i = iMax - 1
            j += 2
            factor *= -1
        } else if (j == -1) {
            j = 0
            factor *= -1
        }
    }
    return res
}

fun main() {
    val t = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    findDiagonalOrder(t).joinToString { "$it " }.apply { println(this) }
}

