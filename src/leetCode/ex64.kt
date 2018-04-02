package leetCode

fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    val temp = Array(grid[0].size){0}
    if (grid[0].isEmpty()) return 0
    temp[0]=grid[0][0]
    (1 until temp.size).forEach {
        temp[it]=grid[0][it]+temp[it-1]
    }

    (1 until grid.size).forEach {
        r->
        temp[0] += grid[r][0]
        (1 until temp.size).forEach {
            c->
            temp[c] = Math.min(temp[c],temp[c-1])+grid[r][c]
        }
    }

    return temp[temp.size-1]
}
