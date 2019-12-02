package leetCode

import kotlin.math.*
import kotlin.test.*

fun maxProfit(k: Int, prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }
    val t =
            if (k > prices.size / 2) {
                prices.size / 2
            } else {
                k
            }
    val cost = Array(t + 1) { intArrayOf(0, -prices[0]) }
    for (i in prices.indices) {
        for (j in 1..t) {
            cost[j][0] = max(cost[j][0], cost[j][1] + prices[i])
            cost[j][1] = max(cost[j][1], cost[j - 1][0] - prices[i])
        }
    }
    return cost.maxBy { it[0] }?.get(0) ?: 0
}


