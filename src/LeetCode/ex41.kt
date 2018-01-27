package LeetCode

fun firstMissingPositive(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        if (nums[i] <= nums.size && nums[i] > 0 && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
            val temp = nums[nums[i] - 1]
            nums[nums[i] - 1] = nums[i]
            nums[i] = temp
            i--
        }
        i++
    }
    for ((index, value) in nums.withIndex()) {
        if (index != (value - 1)) {
            return index + 1
        }
    }
    return nums.size+1
}

fun main(args: Array<String>) {
    firstMissingPositive(intArrayOf(1, 1)).apply(::println)
}