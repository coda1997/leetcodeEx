package leetCode

fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    return Math.max(rec1[0],rec2[0])<Math.min(rec1[2],rec2[2])&&
            Math.max(rec1[1],rec2[1])<Math.min(rec1[3],rec2[3])
}



fun main(args: Array<String>) {
    isRectangleOverlap(intArrayOf(0,0,2,2), intArrayOf(1,1,3,3)).apply { println(this) }
    isRectangleOverlap(intArrayOf(0,0,1,1), intArrayOf(1,0,2,1)).apply { println(this) }
}