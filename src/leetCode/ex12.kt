package leetCode

private fun intToRoman(num: Int): String {
    val s = arrayOf(
        arrayOf(
            "","I","II","III","IV","V","VI","VII","VIII","IX"
        )
        , arrayOf(
            "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"
        )
        , arrayOf(
            "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"
        )
        , arrayOf(
            "","M","MM","MMM"
        )
    )
    var roman = ""
    roman +=(s[3][(num/1000)%10])
    roman +=(s[2][(num/100)%10])
    roman +=(s[1][(num/10)%10])
    roman +=(s[0][num%10])
    return roman
}

fun main(args: Array<String>) {
    println(intToRoman(1234))
}