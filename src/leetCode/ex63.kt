package leetCode

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val row = obstacleGrid.size
    if (row ==0)
        return 0
    val col = obstacleGrid[0].size
    if (row == 1) return col
    if (col == 1) return row
    return uniquePathsWithObstacles(obstacleGrid,1,0,row,col)+ uniquePathsWithObstacles(obstacleGrid,0,1,row,col)


}
fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>,m:Int,n:Int,row:Int,col:Int): Int {
    if (obstacleGrid[m][n]==1) return 0
    if (m==row-1&&n==col-1) return 1
    val l = if(m<row-1) uniquePathsWithObstacles(obstacleGrid,m+1,n,row,col) else 0
    val r = if (n<col-1) uniquePathsWithObstacles(obstacleGrid,m,n+1,row,col) else 0
    return l+r
}

fun main(args: Array<String>) {
    uniquePathsWithObstacles(arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(0,0,0))).apply { println(this) }
}

