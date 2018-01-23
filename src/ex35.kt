fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size
    while (left<right){
        val mid = (left+right)/2
        when{
            nums[mid]<target-> left=mid+1
            else -> right=mid
        }

    }
    return left
}