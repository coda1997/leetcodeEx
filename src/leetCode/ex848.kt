package leetCode

fun shiftingLetters(S: String, shifts: IntArray): String {
    val temp = S.map { it.toInt()-'a'.toInt() }.toIntArray()
    (0 until shifts.size).forEach {
        shifts[it] = shifts[it] % 26
    }
    var tres = shifts.sum()
    (0 until temp.size).forEach {
        temp[it] = (temp[it]+ tres)%26
        tres -=shifts[it]
    }
    return StringBuilder().apply {
        temp.map { (it+'a'.toInt()).toChar() }.forEach {
            append(it)
        }
    }.toString()
}

fun main(args: Array<String>) {
    shiftingLetters("abc", intArrayOf(3,5,9)).apply { println(this) }
}