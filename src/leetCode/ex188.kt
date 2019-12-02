package leetCode

import kotlin.math.*
import kotlin.test.*

fun maxProfit(k: Int, prices: IntArray): Int {
    val cost = Array(k + 1) { IntArray(2) { 0 } }
    for (i in prices.indices) {
        for (j in 1..k) {
            cost[j][0] = max(cost[j][0], cost[j - 1][1] + prices[i])
            cost[j][1] = max(cost[j - 1][1], cost[j - 1][0] - prices[i])
        }
    }
    return cost.maxBy { it[0] }!![0]
}

fun main() {
    assertEquals(2, maxProfit(2, intArrayOf(2, 4, 1)))
    assertEquals(7, maxProfit(2, intArrayOf(3, 2, 6, 5, 0, 3)))
}