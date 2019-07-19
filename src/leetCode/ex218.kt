package leetCode

import java.util.*

fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    if (buildings.isEmpty()) {
        return res
    }
    if (buildings.size<2){
        res.add(listOf(buildings[0][0], buildings[0][2]))
        res.add(listOf(buildings[0][1], 0))
        return res
    }

    val stack = Stack<List<Int>>()
    var tempMax = buildings[buildings.size-1][2]
    for (i in buildings.size-1 downTo 1) {
        val t1 = buildings[i]
        val t2 = buildings[i-1]
        if (t2[2]>tempMax){
            stack.add(listOf(t2[1],tempMax))
            tempMax= t2[2]

        }




    }
    return res
}