package leetCode

import kotlin.math.*

fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
    val size = arr1.size

    val A = IntArray(size)
    val B = IntArray(size)
    A[0] = abs(arr1[0]-arr2[0])
    B[0] = abs(arr1[0]+arr2[0])
    for (i in 1 until size) {
        A[i] = max(A[i-1], abs(arr1[i]-arr2[i]-i))
        B[i] = max(B[i-1], abs(arr1[i]+arr2[i]-i))
    }
    var res = 0
    for (i in 1 until size) {
        val a = arr1[i]-arr2[i]
        val b = arr1[i]+arr2[i]
        val t1 = max(a+A[i-1],-a+A[i-1])
        val t2 = max(b+B[i-1], -b+B[i-1])
        val t = max(t1,t2)
        res = max(res,t)
    }
    return res
}

fun main() {
    maxAbsValExpr(intArrayOf(1,2,3,4), intArrayOf(-1,4,5,6)).apply { println(this) }
    maxAbsValExpr(intArrayOf(1,-1,-5,0,10), intArrayOf(0,-2,-1,-7,-4)).apply { println(this) }
}