package leetCode

fun largestRectangleArea(heights: IntArray): Int {
    var res = 0
    if (heights.size<=2){
        return heights.minOrNull() ?:0*heights.size
    }
    (1 until heights.size-1).forEach {
        var temp = heights[it]

    }
    return 0
}