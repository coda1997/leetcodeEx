package leetCode

fun sortColors(nums: IntArray): Unit {
    if (nums.isEmpty()||nums.size==1) return
    var t:Int
    var l = -1
    var r = nums.size
    var i = 0
    while (i<r){
        when(nums[i]){
            0->{
                t = nums[i]
                nums[i]=nums[++l]
                if (i<=l){
                    i=l+1
                }
                nums[l]=t
            }
            2->{
                t=nums[i]
                nums[i]=nums[--r]
                nums[r]=t
            }
            else->{
                i++
            }
        }
    }
}

fun main(args: Array<String>) {
    intArrayOf(0,0).apply { sortColors(this) }.forEach { println(it) }
}