package leetCode

fun findMin(nums: IntArray): Int {
    if (nums.size==1){
        return nums[0]
    }
    var l = 0
    var r = nums.size
    if (nums[0]<nums[nums.size-1]){
        return nums[0]
    }
    while (l<r){
        val mid = (r-l)/2+l
        if (nums[mid]>nums[l]){
            l=mid
        }else{
            r=mid
        }
    }
    return nums[l+1]
}

fun main(args: Array<String>) {
    findMin(intArrayOf(3,4,5,1,2)).apply { println(this) }
}