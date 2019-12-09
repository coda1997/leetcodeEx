package leetCode

class NumArray(nums: IntArray) {
    //    val nums = nums
    private val sums = IntArray(nums.size)

    init {
        for (i in nums.indices) {
            if (i == 0) {
                sums[i] = nums[i]
            } else {
                sums[i] = nums[i] + sums[i - 1]
            }
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return if (i==0){
            sums[j]
        }else{
            sums[j]-sums[i-1]
        }
    }

}