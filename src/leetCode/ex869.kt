package leetCode

fun binaryGap(N: Int): Int {
    var t = N
    var res = 0
    var tt = 0
    while (t%2==0){
        t/=2
    }

    while (t!=0){
        if (t%2!=0){
            res=Math.max(res,tt)
            tt=0
        }
        tt++
        t/=2
    }
    return res
}

fun reorderedPowerOf2(N: Int): Boolean {
    val s = N.toString()
    val len = s.length
    var t = 1
    for(i in 0 .. 30){
        t*=2
        println(t)
    }

    return false
}

fun main(args: Array<String>) {
    reorderedPowerOf2(1000000000)
}