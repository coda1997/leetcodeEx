package leetCode

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int{
    if (obstacleGrid.isEmpty()) return 0
    val table = IntArray(obstacleGrid[0].size){0}
    table[0]= if (obstacleGrid[0][0]==1) 0 else 1
    (0 until obstacleGrid.size).forEach { i->
        (0 until obstacleGrid[0].size).forEach {
            when(it){
                0-> if (obstacleGrid[i][0]==1) table[0]=0
                else-> table[it]=if (obstacleGrid[i][it]==1) 0 else table[it]+table[it-1]
            }
        }
    }
    return table[obstacleGrid[0].size-1]
}


fun main(args: Array<String>) {
    uniquePathsWithObstacles(arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(0,0,0))).apply { println(this) }
}

