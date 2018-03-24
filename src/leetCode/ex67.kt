package leetCode

fun addBinary(a: String, b: String) = StringBuilder().apply {
    var exp = 0
    var base :Int

    for (i in 0 until Math.min(a.length, b.length)) {
        base = a[a.length-1-i].toInt()-48 + b[b.length-1-i].toInt()-48 +exp
        exp = base/2
        base %= 2
        append(base)
    }
    if (a.length>b.length){
        for (i in b.length until a.length){
            base = a[a.length-1-i].toInt()-48+exp
            exp = base/2
            base %=2
            append(base)
        }
    }else{
        for (i in a.length until b.length){
            base = b[b.length-1-i].toInt()-48+exp
            exp = base/2
            base %=2
            append(base)
        }
    }


    if (exp==1) append(exp)


}.reverse().toString()

fun main(args: Array<String>) {
    println(addBinary("111","1"))
}

