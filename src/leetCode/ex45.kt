package leetCode

fun jump(nums: IntArray): Int {
    val res = IntArray(nums.size){0}
    (0 until res.size-1).forEach { base->
        (0 until nums[base]).forEach {
            res[base+it] = res[base]+1
        }
    }
    return res[nums.size-1]
}

fun main(args: Array<String>) {
    jump(intArrayOf(2,3,1,1,4)).apply { println(this) }
}