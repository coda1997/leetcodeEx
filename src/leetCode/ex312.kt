package leetCode

import kotlin.math.max
import kotlin.test.assertEquals

fun maxCoins(nums: IntArray): Int {
    val dp = List(nums.size){IntArray(nums.size){0} }
    val tt = IntArray(nums.size+2){1}
    for (i in nums.indices){
        tt[i+1]=nums[i]
    }
    return maxR(1,nums.size,tt,dp)
}

fun maxR(start:Int,end:Int,tt:IntArray,dp:List<IntArray>):Int{
    if (start>end){
        return 0
    }
    if (dp[start-1][end-1]!=0){
        return dp[start-1][end-1]
    }
    var res = 0
    for (i in start..end){
        res = max(tt[start-1]*tt[end+1]*tt[i]+ maxR(start,i-1,tt,dp)+ maxR(i+1,end,tt,dp), res)
    }
    dp[start-1][end-1]=res
    return res
}

fun main() {
    assertEquals(167, maxCoins(intArrayOf(3, 1, 5, 8)))
}