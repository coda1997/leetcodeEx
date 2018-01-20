fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var i = 0
    (1 until nums.size)
            .asSequence()
            .filter { nums[it]!=nums[i] }
            .forEach { nums[++i]=nums[it] }
    return i+1
}

fun main(args: Array<String>) {
    removeDuplicates(intArrayOf(1,1)).apply { println(this) }
}