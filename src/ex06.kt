fun convert(s: String, numRows: Int): String {
    if(numRows==2)
        return s
    val t = Array<String>(numRows) { "" }
    val steps = 2 * numRows - 2
    for (i in 0 until s.length) {
        if (i % steps < numRows) {
            t[i % steps] = t[i % steps] + s[i]
        } else {
            t[steps - i % steps] = t[steps - i % steps] + s[i]
        }
    }
    var res = ""
    for (i in t) {
        res += i
    }
    return res
}

fun main(args: Array<String>) {
    println(convert("PAYPALISHIRING", 3))
}