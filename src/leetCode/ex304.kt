package leetCode

class NumMatrix(matrix: Array<IntArray>) {
    val sumMatrix = Array(matrix.size+1){ IntArray(if (matrix.isEmpty()){1}else{matrix[0].size+1}) }

    init {
        for (row in matrix.indices){
            for (col in matrix[0].indices){
                sumMatrix[row+1][col+1]=matrix[row][col] + sumMatrix[row][col+1]+sumMatrix[row+1][col]-sumMatrix[row][col]
            }
        }
    }
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sumMatrix[row2+1][col2+1]-sumMatrix[row2+1][col1]-sumMatrix[row1][col2+1]+sumMatrix[row1][col1]
    }

}

fun main() {
    val t = NumMatrix(arrayOf(intArrayOf(-4, -5)))
    println(t.sumRegion(0,0,0,1))
}