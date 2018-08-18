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
        max = Math.max(Math.max(max * it, min * it), it)
        min = Math.min(Math.min(t * it, min * it), it)
        res = Math.max(res, max)
    }
    return res
}

fun main(args: Array<String>) {
    maxProduct(intArrayOf(2,3,-2,4)).apply { println(this) }
}