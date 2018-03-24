package leetCode

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val row = when(obstacleGrid.size){
        0->return 0
        1->return obstacleGrid[0].size
        else->obstacleGrid.size
    }
    val col = when(obstacleGrid[0].size){
        0->return 0
        1->return row
        else->obstacleGrid[0].size
    }
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

