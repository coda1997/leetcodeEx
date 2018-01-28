package leetCode

private fun romanToInt(s: String): Int {
    val table = HashMap<Char,Int>()
    table.put('I',1)
    table.put('V',5)
    table.put('X',10)
    table.put('C',100)
    table.put('M',1000)
    table.put('L',50)
    table.put('D',500)
    var res = 0
    for((index,value) in s.withIndex()){
        if(index==s.length-1|| table[value]!! >=table[s[index+1]]!!){
            res +=table[value]!!
        }else{
            res -=table[value]!!
        }
    }
    return res
}

fun main(args: Array<String>) {
    println(romanToInt("DCXXI"))
}