package leetCode

import kotlin.math.*

fun projectionArea(grid: Array<IntArray>): Int {
    var c1 = 0
    var c2 = 0
    val c3 = IntArray(grid.size){0}
    var tempMax: Int
    for (row in grid){
        tempMax = 0
        for((index, item) in row.withIndex()){
            if (item!=0){
                c1++
            }
            tempMax = max(tempMax, item)
            c3[index] = max(c3[index], item)
        }
        c2+=tempMax
    }
    return c1+c2+c3.sum()
}

fun main(args: Array<String>) {
    projectionArea(arrayOf(intArrayOf(2))).apply { println(this) }
    projectionArea(arrayOf(intArrayOf(1,2), intArrayOf(3,4))).apply { println(this) }
    projectionArea(arrayOf(intArrayOf(1,0), intArrayOf(0,2))).apply { println(this) }
    projectionArea(arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,1), intArrayOf(1,1,1))).apply { println(this) }
}