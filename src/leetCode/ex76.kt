package leetCode

fun minWindow(s: String, t: String): String {
    val table = mutableListOf<Int>()
    val hashtable = hashMapOf<Char,Int>()
    t.forEach {
        hashtable.put(it,hashtable.getOrDefault(it,0)+1)
    }
//    hashtable.forEach { t, u ->
//        println("key:$t,value$u")
//    }
    var min = Int.MAX_VALUE
    var l = 0
    var r = 0
    for (i in 0 until s.length){
        if (hashtable.containsKey(s[i])){

        }
    }


    return s
}

fun main(args: Array<String>) {
    minWindow("hello","ABCC")
}