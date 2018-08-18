package leetCode

fun largestOverlap(A: Array<IntArray>, B: Array<IntArray>): Int {
    if (A.isEmpty()) return 0
    val J = A.size
    val I = A[0].size
    var res = 0
    for (j in 0 until J){
        for (i in 0 until I){
            res= Math.max(res, findOverlap(A,B,i,j))
            res = Math.max(res, findOverlap(B,A,i,j))
        }
    }
    return res
}
fun findOverlap(A: Array<IntArray>, B: Array<IntArray>, offsetI:Int, offsetJ: Int):Int{
    var res = 0
    for (j in 0 until A.size){
//        if (j+offsetJ>=A.size){
//            break
//        }
        val I = A[j].size
        for (i in 0 until I){
            if (B[j][i]!=1){continue}
            if (A[(j+offsetJ)%A.size][(i+offsetI)%I]==B[j][i]){
                res++
            }
        }
    }
    return res
}

fun main(args: Array<String>) {
    val A = arrayOf(intArrayOf(1,1,0),
            intArrayOf(0,1,0),
            intArrayOf(0,1,0))
    val B = arrayOf(intArrayOf(0,0,0),
            intArrayOf(0,1,1),
            intArrayOf(0,0,1))
    largestOverlap(A,B).apply { println(this) }
    findOverlap(A,B,1,1).apply { println(this) }
}