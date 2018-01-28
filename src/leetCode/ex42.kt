package leetCode

fun trap(height: IntArray): Int {
    var left= 0
    var right = height.size-1
    var leftMax = 0
    var rightMax = 0
    var res = 0
    while (left<right){
        if (height[left]<height[right]){
            if (height[left]<leftMax){
                res+=leftMax-height[left]
            }else{
                leftMax=height[left]
            }
            left++
        }else{
            if (height[right]<rightMax){
                res+=rightMax-height[right]
            }else{
                rightMax=height[right]
            }
            right--
        }
    }
    return res
}

fun main(args: Array<String>) {
    trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)).apply(::println)
}