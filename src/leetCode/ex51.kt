package leetCode

fun solveNQueens(n: Int): List<List<String>> = mutableListOf<MutableList<String>>().apply{
    add(mutableListOf())
//    res.forEach { println(it) }
    (0 until n).forEach {  }
    arrayListOf("").forEach { value ->
        (size downTo 1).forEach {
            val r = removeAt(0)
            (0..r.size).forEach { i ->
                add(MutableList(r.size) { r[it] }.apply {
                    add(i, value)
                })
            }
        }
    }
    TODO()
}

fun main(args: Array<String>) {
    solveNQueens(3)
}
