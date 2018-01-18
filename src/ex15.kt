private fun threeSum(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    nums.sort()

    var l = 0
    val boundary = nums.size - 2
    while (l < boundary) {
        val target = -nums[l]
        var i = l+1
        var r = nums.size-1
        while (i<r){
            if (nums[i]+nums[r]>target){
                r--
            }else if (nums[i]+nums[r]<target){
                i++
            }else{
                res.add(listOf(nums[i],nums[l],nums[r]))
                do{
                    i++
                }while (nums[i]==nums[i-1]&&i<r)
            }
        }

        do{
            l++
        }while (nums[l]==nums[l-1]&&l<boundary)
    }
    return res
}

fun main(args: Array<String>) {
    threeSum(intArrayOf(-1,0,1,2,-1,-4)).forEach{
        println(it)
    }
}
