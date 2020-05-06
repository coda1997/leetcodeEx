package leetCode

import kotlin.math.max
import kotlin.math.min
import kotlin.test.assertEquals

fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
    val x1 = max(A, E)
    val y1 = max(B, F)
    val x2 = min(C, G)
    val y2 = min(D, H)
    return if (x2<=x1||y2<=y1){
        (C - A) * (D - B) + (G - E) * (H - F)
    }else
        (C - A) * (D - B) + (G - E) * (H - F) - (x2 - x1) * (y2 - y1)
}

fun main() {
    assertEquals(45, computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
    assertEquals(17, computeArea(-2, -2, 2, 2, 3, 3, 4, 4))
}

