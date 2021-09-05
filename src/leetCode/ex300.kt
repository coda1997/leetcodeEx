package leetCode

import kotlin.math.max
import kotlin.test.assertEquals

fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()){
        return 0
    }
    val tt = IntArray(nums.size){1}
    for (i in nums.indices){
        for (j in 0 until i){
            if (nums[i]>nums[j]){
                tt[i] = max(tt[i],tt[j]+1)
            }
        }
    }
    return tt.maxOrNull() ?:1
}

fun main() {
    assertEquals(4, lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}