package leetCode

fun spiralOrder(matrix: Array<IntArray>): List<Int> = mutableListOf<Int>().takeUnless { matrix.isEmpty() }?.apply {
    var offset = 0
    var flag = true
    while (flag) {
        flag = false
        (offset until matrix[0].size - offset).apply {
            forEach { add(matrix[offset][it]) }
        }.takeUnless { it.isEmpty() }?.run {
            (offset + 1 until matrix.size - offset).apply {
                forEach { add(matrix[it][matrix[0].size - offset - 1]) }
            }.takeUnless { it.isEmpty() }?.run {
                (matrix[0].size - 2 - offset downTo offset).apply {
                    forEach { add(matrix[matrix.size - 1 - offset][it]) }
                }.takeUnless { it.isEmpty() }?.run {
                    (matrix.size - 2 - offset downTo offset + 1).forEach {
                        add(matrix[it][offset])
                        flag = true
                    }
                }
            }
        }
        offset++
    }
} ?: listOf()

fun main(args: Array<String>) {
    spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))).apply { println(this) }

}
