package leetCode

import kotlin.math.sqrt
import kotlin.test.assertEquals

fun bulbSwitch(n: Int): Int {
    return sqrt(n.toDouble()).toInt()
}

fun main() {
    assertEquals(1, bulbSwitch(3))
}