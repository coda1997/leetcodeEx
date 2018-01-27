package LeetCode

private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty())
        return listOf()
    var list = mutableListOf("")
    for (c in digits){
        val plist = mutableListOf<String>()
        when(c) {
            '0'->list.forEach { plist.add(it+" ") }
            '2'->list.forEach{
                plist.add(it+"a")
                plist.add(it+"b")
                plist.add(it+"c")
            }
            '3'->list.forEach{
                plist.add(it+"d")
                plist.add(it+"e")
                plist.add(it+"f")
            }
            '4'->list.forEach{
                plist.add(it+"g")
                plist.add(it+"h")
                plist.add(it+"i")
            }
            '5'->list.forEach{
                plist.add(it+"j")
                plist.add(it+"k")
                plist.add(it+"l")
            }
            '6'->list.forEach{
                plist.add(it+"m")
                plist.add(it+"n")
                plist.add(it+"o")
            }
            '7'->list.forEach{
                plist.add(it+"p")
                plist.add(it+"q")
                plist.add(it+"r")
                plist.add(it+"s")
            }
            '8'->list.forEach{
                plist.add(it+"t")
                plist.add(it+"u")
                plist.add(it+"v")
            }
            '9'->list.forEach{
                plist.add(it+"w")
                plist.add(it+"x")
                plist.add(it+"y")
                plist.add(it+"z")
            }
            else-> println("Oops error!")
        }
        list=plist
    }
    return list
}

fun main(args: Array<String>) {
    letterCombinations("23").forEach(::println)
}
