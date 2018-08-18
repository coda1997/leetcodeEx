package leetCode

fun findReplaceString(S: String, indexes: IntArray, sources: Array<String>, targets: Array<String>): String {
    var base = 0
    var res = S
    
    for(j in 0 until  indexes.size){
        val i = indexes[j]
        val index = i+base
        if (res.substring(index,index+sources[j].length)==sources[j]){
            base+= targets[j].length-sources[j].length
            res=res.substring(0,index)+targets[j]+res.substring(index+sources[j].length)
        }
    }
    return res
}

fun main(args: Array<String>) {
    findReplaceString("abcd",
            intArrayOf(0,2),
            arrayOf("a","cd"),
            arrayOf("eee","ffff")).apply { println(this) }
}