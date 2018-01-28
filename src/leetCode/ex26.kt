package leetCode

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var i = 0
    (1 until nums.size)
            .filter { nums[it]!=nums[i] }
            .forEach { nums[++i]=nums[it] }
    return i+1
}

