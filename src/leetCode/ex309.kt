package leetCode

import kotlin.math.max
import kotlin.test.assertEquals

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }
    val t1 = IntArray(prices.size)
    val t2 = IntArray(prices.size)
    t2[0]=-prices[0]
    for (i in 1 until prices.size){
        if (i==1){
            t1[i]= max(t2[i-1]+prices[i],t1[i-1])
            t2[i]= max(-prices[i],t2[i-1])
            continue
        }
        t1[i]= max(t2[i-1]+prices[i],t1[i-1])
        t2[i]= max(t1[i-2]-prices[i],t2[i-1])

    }
    return t1.last()
}

fun main() {
    assertEquals(3, maxProfit(intArrayOf(1,2,3,0,2)))
}