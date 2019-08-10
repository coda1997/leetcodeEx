package leetCode

fun canTransform(start: String, end: String): Boolean {
    if (!checkRL(start, end)) {
        return false
    }
    var p1 = findX(start, -1)
    var p2 = findX(end, -1)
    while (p1>-1&&p2>-1){
        if (p2>p1){
            for (i in (p1+1) .. p2){
                if (start[i]=='R'){
                    return false
                }
            }
        }else if (p2<p1){
            for (i in p2 until p1){
                if (start[i]=='L'){
                    return false
                }
            }
        }
        p1 = findX(start, p1)
        p2 = findX(end, p2)
    }
    return true
}

fun findX(s:String,index:Int):Int{
    for (i in index + 1 until s.length) {
        if (s[i]=='X'){
            return i
        }
    }
    return -1
}

fun checkRL(start:String, end: String):Boolean{
    if (start.length!=end.length){
        return false
    }
    val sI1 =start.iterator()
    val sI2 =end.iterator()
    while (sI1.hasNext()){
        val c = sI1.nextChar()
        if (c=='X'){
            continue
        }
        var cc = sI2.nextChar()
        while (cc=='X'&&sI2.hasNext()){
            cc=sI2.nextChar()
        }
        if (c!=cc){
            return false
        }
    }
    while (sI2.hasNext()){
        if (sI2.nextChar()!='X'){
            return false
        }
    }
    return true
}

fun main() {
    canTransform("RXXLRXRXL","XRLXXRRLX").apply { println(this) }
    canTransform("XXLXX","XXLXX").apply { println(this) }
    canTransform("L","X").apply { println(this) }
    canTransform("XXLXX","LXXXX").apply { println(this) }
}