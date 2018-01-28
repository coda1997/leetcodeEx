package leetCode

fun removeElement(nums: IntArray, `val`: Int): Int {
    if (nums.isEmpty())
        return 0
    var i =0
    (0 until nums.size).filter { nums[it]!=`val` }.forEach { nums[i++]=nums[it] }
    return i
}