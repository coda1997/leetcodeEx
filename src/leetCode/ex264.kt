package leetCode

import kotlin.math.min

fun nthUglyNumber(n: Int): Int {
    var i = 0
    var j = 0
    var k = 0
    val tt = IntArray(n)
    tt[0]=1
    for (index in 1 until n){
        tt[index] = min(min(tt[i] * 2, tt[j]*3), tt[k]*5)
        if (tt[index] == tt[i]*2) {
            i++
        }
        if (tt[index] == tt[j]*3) {
            j++
        }
        if (tt[index] == tt[k]*5) {
            k++
        }
    }
    return tt[n-1]
}

fun main() {
    nthUglyNumber(10)
}