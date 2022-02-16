package leetCode

import kotlin.math.max
import kotlin.math.min

fun countOperations(num1: Int, num2: Int): Int {
    var l = max(num1, num2)
    var r = min(num1, num2)
    var count = 0
    while (r>0){
        count += l/r
        val temp = r
        r = l%r
        l = temp
    }
    return count
}

fun main() {
    println(countOperations(2,3))
    println(countOperations(10,10))
}