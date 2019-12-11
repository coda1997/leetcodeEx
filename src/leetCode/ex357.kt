package leetCode

fun countNumbersWithUniqueDigits(n: Int): Int {
    if(n>10){
        return 0
    }
    if (n==0){
        return 1

    }
    var t1 = 1
    var t2 = 10
    for (i in 2 .. n){
        val t = t2
        t2 += (t2 - t1) * (11 - i)
        t1 = t
    }
    return t2
}

fun main() {
    println(countNumbersWithUniqueDigits(3))
}
