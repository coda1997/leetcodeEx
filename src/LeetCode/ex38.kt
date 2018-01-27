package LeetCode

fun countAndSay(n: Int): String {
    var res = "1"
    val regax = "1+|2+|3+|4+|5+|6+|7+|8+|9+".toRegex()
    (1 until n).forEach {
        val o=StringBuilder()
        regax.findAll(res).forEach { o.append(it.value.length).append(it.value[0]) }
        res=o.toString()
    }
    return res
}

fun main(args: Array<String>) {
    countAndSay(5).apply(::println)
}