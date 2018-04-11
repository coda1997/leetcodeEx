package leetCode

fun letterCasePermutation(S: String): List<String> {
    var res = mutableListOf<String>()
    res.add("")
    S.forEach { c->
        val temp = mutableListOf<String>()
        res.forEach {t->
            if (c.isDigit()){
                temp.add(t+c)
            }else if (c.isLetter()){
                temp.add(t+c.toLowerCase())
                temp.add(t+c.toUpperCase())
            }
        }
        res = temp
    }
    return res
}

fun main(args: Array<String>) {
    letterCasePermutation("a1b2").apply(::println)
}