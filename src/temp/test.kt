package temp

fun main() {
    val t = 3
    val res = mutableListOf<Int>()
    if(t.and(1)>0){
        res.add(0)
    }
    if(t.and(2)>0){
        res.add(1)
    }
    if(t.and(4)>0){
        res.add(2)
    }
    println(res.joinToString())
    println(t.and(2))
}