package leetCode

fun climbStairs(n: Int):Int{
    val table = IntArray(n)
    table[0]=1
    table[1]=2
    for (i in 2 until n){
        table[i]=table[i-1]+table[i-2]
    }
    return table[n-1]
}

fun main(args: Array<String>) {
    climbStairs(45).apply { println(this) }
}