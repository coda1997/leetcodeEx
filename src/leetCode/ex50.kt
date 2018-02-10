package leetCode

fun myPow(x: Double, n: Int): Double {
    if (n == 0) {
        return 1.0
    }
    var times = if (n > 0) n.toLong() else -n.toLong()
    val xx = if (n > 0) x else 1 / x
    var res = xx
    while (times > 1) {
        res = if (times % 2 == 1.toLong()) res * res * xx
        else res * res
        times /= 2
    }
    return res
}

fun main(args: Array<String>) {
    intArrayOf( -5).forEach { myPow(8.84372, it).apply(::println) }
}