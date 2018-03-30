package leetCode

fun divide(dividend: Int, divisor: Int): Int {
    if (divisor==0) return Int.MAX_VALUE
    if (dividend== Int.MIN_VALUE&&divisor==1) return dividend
    if (dividend>0){
        return -divide(-dividend,divisor)
    }
    if (divisor>0){
        return -divide(dividend,-divisor)
    }
    var temp = divisor
    var res = 0
    while (temp>=dividend&&temp<0){
        temp +=divisor
        if (res==Int.MAX_VALUE) return res
        res++
    }

    return res
}

fun main(args: Array<String>) {
    divide(1,1).apply { print(this) }
}