package leetCode

fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var max = nums[0]
    var min = nums[0]
    var res = nums[0]
    (1 until nums.size).forEach {item->
        val it = nums[item]
        val t = max
        max = kotlin.math.max(kotlin.math.max(max * it, min * it), it)
        min = kotlin.math.min(kotlin.math.min(t * it, min * it), it)
        res = kotlin.math.max(res, max)
    }
    return res
}

fun main(args: Array<String>) {
    maxProduct(intArrayOf(2,3,-2,4)).apply { println(this) }
}