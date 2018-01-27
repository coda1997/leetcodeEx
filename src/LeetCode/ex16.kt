package LeetCode
fun threeSumClosest(nums: IntArray, target: Int): Int {
    var res =0
    nums.sort()
    var l = 0
    val boundary = nums.size - 2
    var closest:Int = Int.MAX_VALUE
    while (l < boundary) {
        val targets = target-nums[l]
        var i = l+1
        var r = nums.size-1
        while (i<r){
            val sum = nums[i]+nums[l]+nums[r]
            when {
                nums[i]+nums[r]>targets -> r--
                nums[i]+nums[r]<targets -> i++
                else -> return sum
            }
            if(Math.abs(sum-target)<closest){
                closest = Math.abs(sum - target)
                res = sum
            }
        }
        do{
            l++
        }while (nums[l]==nums[l-1]&&l<boundary)
    }
    return res
}

fun main(args: Array<String>) {
    threeSumClosest(intArrayOf(-1, 2, 1, 4), 1).apply { println(this) }
}