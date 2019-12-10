package leetCode

fun search(nums: IntArray, target: Int): Boolean= binarySearch(nums,0,nums.size-1,target)

fun binarySearch(nums: IntArray,left:Int,right:Int,target: Int):Boolean{
    if (right<left){
        return false
    }
    val mid = (left+right)/2
    val mt = nums[mid]

    if (nums[left]==target){
        return true
    }
    if (nums[right]==target){
        return true
    }
    if (nums[left]==mt){
        return binarySearch(nums, left+1, right, target)
    }
    return if (mt<target) {
        if (nums[left] in mt + 1 until target){
            binarySearch(nums,left,mid-1,target)
        }else{
            binarySearch(nums,mid+1,right,target)
        }
    }
    else if (mt>target) {
        if (nums[left] in target + 1 until mt){
            binarySearch(nums, mid+1, right, target)
        }else{
            binarySearch(nums,left,mid-1,target)
        }
    }
    else {true}
}

fun main() {
    search(intArrayOf(2,5,6,0,0,1,2),0).apply { println(this) }
    search(intArrayOf(2,5,6,0,0,1,2),3).apply { println(this) }
    search(intArrayOf(1,3),3).apply { println(this) }
    search(intArrayOf(3,1),3).apply { println(this) }
    search(intArrayOf(3,1,1),3).apply { println(this) }
    search(intArrayOf(1,3,1,1,1),3).apply { println(this) }
    search(intArrayOf(1,1,1,3,1),3).apply { println(this) }
}

