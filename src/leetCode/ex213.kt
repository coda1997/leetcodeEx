package leetCode

import kotlin.math.max
import kotlin.test.assertEquals

fun rob2(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    if (nums.size==1){
        return nums[0]
    }
    var m = 0
    var n = nums[0]
    var t :Int
    for (i in 1 until nums.size){
        t = n
        n = max(n,m+nums[i])
        m = t
    }
    val res1 = m
    m = 0
    n = 0
    for (i in 1 until nums.size) {
        t = n
        n = max(n,m+nums[i])
        m = t
    }
    return max(res1,n)
}

fun main() {
    assertEquals(1, rob2(intArrayOf(1)))
    assertEquals(2, rob2(intArrayOf(1,2)))
    assertEquals(3, rob2(intArrayOf(2,3,2)))
    assertEquals(4, rob2(intArrayOf(1,2,3,1)))
}