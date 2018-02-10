package leetCode

fun maxSubArray(nums: IntArray): Int {
    var localMax  = nums[0]
    var globalMax = localMax
    (1 until nums.size).forEach {
        localMax=Math.max(localMax+nums[it],nums[it])//get the left point
        globalMax=Math.max(globalMax,localMax)//determine the right end
    }
    return globalMax
}

fun main(args: Array<String>) {
    maxSubArray(intArrayOf(1,2,-1,-2,2,1,-2,1,4,-5,4)).apply { println(this) }
}