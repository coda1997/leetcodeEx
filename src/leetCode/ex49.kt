package leetCode

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val res = hashMapOf<String, MutableList<String>>()
    strs.forEach {
        when {
            res.containsKeyUnordered(it) -> res.putWithUnorderedKey(it)
            else -> res.put(it, mutableListOf(it))
        }
    }
    return res.values.toList()
}

private fun HashMap<String, MutableList<String>>.containsKeyUnordered(string: String): Boolean {
    return this.keys.count { it.containsLowerCase(string) } > 0
}
private fun HashMap<String,MutableList<String>>.putWithUnorderedKey(string: String){
    get(keys.find{it.containsLowerCase(string)})?.add(string)
}
private fun String.containsLowerCase(string: String): Boolean {
    if (length!=string.length)
        return false
    val s1 = toCharArray().apply { sort() }
    val s2 = string.toCharArray().apply { sort() }
    return s1.contentEquals(s2)
}

fun main(args: Array<String>) {
    groupAnagrams(arrayOf("eet","ett")).forEach(::println)
}