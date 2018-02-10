package leetCode

fun canJump(nums: IntArray): Boolean {
    var index = 0
    var reach = 0
    while (index<nums.size&&index<=reach){
        reach = Math.max(index+nums[index],reach)
        index++
    }
    return index==nums.size
}

fun main(args: Array<String>) {
    canJump(intArrayOf(3,2,1,0,4)).apply { println(this) }
}

