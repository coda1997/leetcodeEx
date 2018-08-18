package leetCode

fun transpose(A: Array<IntArray>): Array<IntArray> {
    if (A.isEmpty()){
        return arrayOf(intArrayOf())
    }
    val r = A.size
    val c = A[0].size
    val res = Array<IntArray>(c){IntArray(r)}
    (0 until c).forEach { row->
        (0 until r).forEach { col ->
            res[row][col] = A[col][row]
        }
    }
    return res
}

fun main(args: Array<String>) {
    transpose(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6))).apply {
        forEach {
            it.forEach (::print)
            println()
        }
    }
}