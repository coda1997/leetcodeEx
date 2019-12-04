package leetCode

import kotlin.math.min
import kotlin.test.assertEquals

fun numSquares(n: Int): Int {
    val t = IntArray(n+1)
    for (i in 1 until (n+1)){
        t[i]=i
        var j = 1
        while (j*j<=i){
            t[i]= min(t[i],t[i-j*j]+1)
            j++
        }
    }
    return t[n]
}

fun main() {
    assertEquals(3, numSquares(12))
    assertEquals(1, numSquares(16))
}