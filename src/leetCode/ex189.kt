package leetcode

fun rotate(nums: IntArray, k: Int): Unit {
    val len = nums.size
    val kk = k%len
    reverseNums(nums,0,len-1)
    reverseNums(nums,0,kk-1)
    reverseNums(nums,kk,len-1)
}
fun reverseNums(nums: IntArray,start:Int,end:Int){
    var i = start
    var j = end
    var p:Int
    while (i<j){
        p = nums[i]
        nums[i]=nums[j]
        nums[j]=p
        i++
        j--
    }
}
fun main(args: Array<String>) {
    val demo1 = intArrayOf(1,2,3,4,5,6)
    rotate(demo1,3)
    demo1.forEach(::println)
}