package leetCode

fun minCostClimbingStairs(cost: IntArray): Int {
    if (cost.size==2) return Math.min(cost[0],cost[1])
    val table = IntArray(cost.size+1)
    table[0]=0
    table[1]=0
    (2 .. cost.size).forEach { table[it]=Math.min(table[it-1]+cost[it-1],table[it-2]+cost[it-2]) }
    return table[cost.size]
}

fun main(args: Array<String>) {
    minCostClimbingStairs(intArrayOf(0,0,1,1)).apply { println(this) }
}