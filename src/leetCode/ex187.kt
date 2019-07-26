package leetCode

fun findRepeatedDnaSequences(s: String): List<String> {
    if (s.length < 11) {
        return listOf()
    }
    //Initialization
    val map = hashMapOf<Int, Int>()
    val encodeRes = IntArray(s.length-9)
    for (i in 0..9) {
        encodeRes[0] *= 4
        encodeRes[0] += encodeDNA(s[i])
    }
    map[encodeRes[0]] = map.getOrDefault(encodeRes[0], 0) + 1
    // loop only once
    for (index in 1 until s.length-9){
        encodeRes[index] = encode10to4(s,index,encodeRes[index-1])
        map[encodeRes[index]] = map.getOrDefault(encodeRes[index], 0) + 1
    }
    return map.filterValues { it > 1 }.map {
        val index = encodeRes.indexOf(it.key)
        s.substring(index, index + 10)
    }
}

fun encode10to4(s: String, index:Int, pre:Int) = (pre - encodeDNA(s[index-1])*262144)*4 + encodeDNA(s[index+9])


fun encodeDNA(c: Char) = when (c) {
    'A' -> 0
    'C' -> 1
    'G' -> 2
    else -> 3
}

fun main() {
    findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").forEach { println(it) }
}