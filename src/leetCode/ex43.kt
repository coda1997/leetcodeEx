package leetCode

fun multiply(num1: String, num2: String): String {
    val res = Array(num1.length + num2.length) { 0 }
    for (len1 in num1.length - 1 downTo 0) {
        for (len2 in num2.length - 1 downTo 0) {
            val temp = num1[len1] * num2[len2]
            res[len1 + len2] += (temp + res[len1 + len2 + 1]) / 10
            res[len1 + len2 + 1] = (res[len1 + len2 + 1] + temp) % 10
        }
    }
    val sb = StringBuilder()
    var isB = false
    res.filter{ if (it != 0) {
        isB = true
    }
        isB
    }.forEach { sb.append(it) }
    return if (sb.isEmpty()) "0" else sb.toString()
}

private fun Char.toRealInt(): Int {
    return this.toInt() - '0'.toInt()
}

private operator fun Char.times(c: Char): Int {
    return this.toRealInt() * c.toRealInt()
}

fun main(args: Array<String>) {
    multiply("11", "1000").apply(::println)
}