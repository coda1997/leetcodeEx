
fun maximumGap(nums: IntArray): Int {
    if(nums.size<2){
        return 0
    }
    val max = nums.max() ?:0
    val min = nums.min() ?:0

    val d = Math.max(1, (max-min)/(nums.size-1))
    val dt = (max-min) / d + 1
    val t = Array<IntArray>(dt){
        intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)
    }
    for (item in nums) {
        val index = (item-min)/d
        t[d][0] = Math.max(t[d][0], item)
        t[d][1] = Math.min(t[d][1], item)
    }
    var res = 0
    for (i in 1 until d) {
        res = Math.max(res, t[i][1]-t[i-1][0])
    }
    return res
}