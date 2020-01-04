package leetCode

import kotlin.math.min
import kotlin.test.assertEquals

fun coinChange(coins: IntArray, amount: Int): Int {
    val tt = IntArray(amount + 1) { Int.MAX_VALUE }
    tt[amount]=0
    for (i in amount downTo 0) {
        for (coin in coins) {
            if (i - coin >= 0) {
                if (tt[i]== Int.MAX_VALUE){
                    continue
                }
                tt[i - coin] = min(tt[i - coin], tt[i] + 1)
            }
        }
    }
    return if (tt[0] == Int.MAX_VALUE) {
        -1
    } else {
        tt[0]
    }
}

fun main() {
    assertEquals(3, coinChange(intArrayOf(1,2,5),11))
    assertEquals(0, coinChange(intArrayOf(1,2,5),0))
    assertEquals(20, coinChange(intArrayOf(186, 419, 83, 408), 6249))
    assertEquals(-1, coinChange(intArrayOf(2), 3))
}