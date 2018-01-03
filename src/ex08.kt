fun myAtoi(str: String): Int {
    if (str.isEmpty())
        return 0
    var res = 0
    var count = 0
    var falg = false
    var hasnum = false
    for (i in str) {
        if (i == ' ') {
            if (hasnum) break
            else continue

        }
        if (i == '+' || i == '-') {
            if (i == '-') falg = true
            count++
            continue
        }
        if (!i.isDigit())
            break
        res *= 10
        res += when (i) {
            '0' -> 0
            '1' -> 1
            '2' -> 2
            '3' -> 3
            '4' -> 4
            '5' -> 5
            '6' -> 6
            '7' -> 7
            '8' -> 8
            '9' -> 9
            else -> 0
        }
        hasnum = true
    }
    if (count > 1) return 0
    return if (falg) -res else res
}

fun main(args: Array<String>) {
    println(myAtoi("    010"))
}