package leetCode

fun titleToNumber(s: String): Int {
    var res = 0
    for (c in s) {
        res *= 26
        res += c.charToInt()
    }
    return res
}
fun Char.charToInt():Int{
    return this.toInt()-'A'.toInt()+1
}
fun main(args: Array<String>) {
    println(titleToNumber("AB"))
}