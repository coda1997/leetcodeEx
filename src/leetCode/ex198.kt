package leetCode

import kotlin.math.max
import kotlin.test.assertEquals

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var n = 0
    var m = nums[0]
    var t :Int
    for (i in 1 until nums.size) {
        t = m
        m = max(n + nums[i], m)
        n = t
    }
    return m
}

fun main() {
    assertEquals(4, rob(intArrayOf(1, 2, 3, 1)))
    assertEquals(12, rob(intArrayOf(2, 7, 9, 3, 1)))
}