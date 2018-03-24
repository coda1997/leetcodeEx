package leetCode

fun plusOne(digits: IntArray)= digits.apply {
    var base:Int
    var exp = 0
    (digits.size-1 downTo 1).forEach {
        base = when (it) {
            digits.size-1 -> digits[it]+1+exp
            else -> digits[it]+exp
        }
        exp = base/10
        digits[it] =base%10
    }
    base = digits[0]+exp + if(digits.size==1) 1 else 0
    digits[0]=base%10
    return when(base/10){
        1-> {
            mutableListOf<Int>().apply { add(1)
            digits.forEach { add(it) }
        }.toIntArray()}
        else-> digits
    }

}


fun main(args: Array<String>) {
    plusOne(intArrayOf(9,9,9)).forEach { print(it) }
    println()
}