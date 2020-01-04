package leetCode

import kotlin.test.assertEquals

fun isPowerOfThree(n: Int): Boolean {
    return n > 0 && 1162261467%n == 0
}

fun main() {
    assertEquals(true, isPowerOfThree(27))
    assertEquals(false, isPowerOfThree(0))
    assertEquals(true, isPowerOfThree(9))
    assertEquals(false, isPowerOfThree(45))
}