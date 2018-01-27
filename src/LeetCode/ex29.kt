package LeetCode

fun divide(dividend: Int, divisor: Int): Int {
    if (divisor != 0) {
        var res = 0
        var temp=0
        while (temp+divisor<=dividend){
            temp+= divisor
            res++
        }
        return res
    }
    return Int.MAX_VALUE
}
//bullshit