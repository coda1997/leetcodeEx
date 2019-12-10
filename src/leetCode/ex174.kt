package leetCode

fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    if (dungeon.isEmpty() || dungeon[0].isEmpty()) return 0
    val res = Array(dungeon[0].size) { 0 }
    res[res.size - 1] = 1
    (res.size - 2 downTo 0).forEach {
        val num = res[it + 1] - dungeon[dungeon.size - 1][it + 1]
        res[it] = if (num > 0) {
            num
        } else {
            1
        }

    }

    (dungeon.size - 2 downTo 0).forEach {
        res[res.size - 1] = if (res[res.size - 1] - dungeon[it + 1][res.size - 1] > 0) {
            res[res.size - 1] - dungeon[it + 1][res.size - 1]
        } else {
            1
        }
        (res.size - 2 downTo 0).forEach { item ->
            val t1 = if (res[item + 1] - dungeon[it][item + 1] > 0) {
                res[item + 1] - dungeon[it][item + 1]
            } else 1
            val t2 = if (res[item] - dungeon[it + 1][item] > 0) {
                res[item] - dungeon[it + 1][item]
            } else 1
            res[item] = Math.min(t1, t2)
        }
    }
    return if (res[0]-dungeon[0][0]>0) res[0]-dungeon[0][0] else 1
}