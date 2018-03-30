package leetCode

// the shitty problem, it's sick
fun myAtoi(str: String): Int {
    var index = 0
    while (index < str.length && str[index] == ' ') {
        index++
    }
    if (index == str.length || (str[index] != '+' && str[index] != '-' && !isNum(str[index]))) {
        return 0
    }
    val symbol = if (str[index] == '-') -1 else 1
    var res: Int
    if (!isNum(str[index])) {
        index++
    }
    if (index == str.length||str[index]=='+'||str[index]=='-'||!str[index].isDigit()) return 0

    res = str[index++].toInt() - 48
    while (index < str.length && isNum(str[index])) {

        if (res>Int.MAX_VALUE/10) {
            return if (symbol < 0) Int.MIN_VALUE else Int.MAX_VALUE
        }
        res *= 10
        res += str[index].toInt() - 48
        index++
        if (res<0) {
            return if (symbol < 0) Int.MIN_VALUE else Int.MAX_VALUE
        }
    }

    return res * symbol
}

fun isNum(c: Char): Boolean {
    return c.isDigit()
}

fun main(args: Array<String>) {
    println('1'.toInt() - 48)
    println(myAtoi("    10522545459"))
}