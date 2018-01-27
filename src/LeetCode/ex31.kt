package LeetCode

fun nextPermutation(nums: IntArray) {
    var r = nums.size-2
    while (r>=0&&nums[r]>=nums[r+1]) r--
    when (r) {
        -1 -> {
            verse(nums, 0, nums.size - 1)
        }
        nums.size-2-> verse(nums, r, r + 1)
        else -> {
            var s = r + 1
            while (s < nums.size && nums[r] < nums[s]) s++
            wap(nums, r, s - 1)
            verse(nums, r + 1, nums.size - 1)
        }
    }
}

private fun wap(nums: IntArray,i:Int,j:Int){
    val temp = nums[i]
    nums[i]=nums[j]
    nums[j]=temp
}

private fun verse(nums: IntArray,start:Int,end:Int){
    val len = end-start+1
    (0 until len/2).forEach { i -> wap(nums, i = i + start, j = end - i) }
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1,3,2)
    nextPermutation(nums)
    nums.forEach { print(""+it+" ") }
}