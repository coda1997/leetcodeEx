package leetcode

fun rotate(nums: IntArray, k: Int): Unit {
    val size = nums.size
    if(size==0){
        return
    }
    val kk = k%size
    var temp = nums[0]
    var p = kk
    var temp2 = nums[p]
    (0 until size).forEach{
        nums[p]=temp
        p = (p+kk)%size
        temp = temp2
        temp2 = nums[p]
    }
    return
}

fun main(args: Array<String>) {
    val demo1 = intArrayOf(1,2,3,4,5,6)
    rotate(demo1,3)
    demo1.forEach(::println)
}