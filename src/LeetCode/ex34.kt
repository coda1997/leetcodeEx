package LeetCode

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()){
        return intArrayOf(-1,-1)
    }
    var left = 0
    var right = nums.size
    while (left<right){
        val mid = (left+right)/2
        if (nums[mid]<target) {
            left=mid+1
        }
        else {
            right=mid
        }
    }
    if (left>=nums.size)
        return intArrayOf(-1,-1)
    val start= if (nums[left]==target) left else return intArrayOf(-1,-1)
    right=nums.size
    while (left<right){
        val mid = (left+right)/2
        if (nums[mid]>target) {
            right=mid
        }
        else {
            left=mid+1
        }
    }
    return intArrayOf(start,left-1)
}

fun main(args: Array<String>) {
    searchRange(intArrayOf(1, 2, 3, 3, 3, 4, 5), 3).forEach{ println(it)}
}