package leetCode

fun mySqrt(x: Int): Int {
    return Math.sqrt(x.toDouble()).toInt()
}

fun main(args: Array<String>) {
    mySqrt(9).apply { println(this) }
    mySqrt(8).apply { println(this) }
}