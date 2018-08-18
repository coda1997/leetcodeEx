fun removeDuplicates(nums: IntArray): Int {
    var t = 0
    if (nums.size<=1){
        return t
    }
    (1 until nums.size).forEach {
        if (nums[t]!=nums[it]){
            nums[++t]=nums[it]
        }
    }
    return t
}

fun maxProfit(prices: IntArray): Int {
    var res = 0
    for (i in 1 until prices.size){
        val temp = prices[i] - prices[i - 1]
        if (temp >0){
            res+= temp
        }
    }
    return res
}

fun rotate(nums: IntArray, k: Int): Unit {
    if (nums.isEmpty()) return
    val kk = k%nums.size
    var temp = 0
    for (i in 0 until kk){
        var j = 1
        var tt:Int=j*kk+i
        while (j*kk+i<nums.size){
            temp = nums[tt]
            nums[tt]=nums[tt-kk]
            tt=(++j)*kk+i
        }
        nums[(j*kk+i)%nums.size]=temp
    }
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 1, 2,-1,0)
//    removeDuplicates(nums).apply { println(this) }
//    nums.forEach { print("$it ") }
    //maxProfit(intArrayOf(1,2,3,4)).apply { println(this) }
    rotate(nums,3)
    nums.forEach { print(" $it") }
}