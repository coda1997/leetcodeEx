package leetCode

fun generateParenthesis(n: Int): List<String> {
    val list = mutableListOf<String>()
    recursionOfP("", 0, n * 2, list)
    return list.filter { it.isVaild() }
}
fun String.isVaild():Boolean{
    val lock = arrayListOf<Char>()
    try {
        loop@ for(c in this){
            when(c){
                '('->lock.add(0,c)
                ')'-> if(lock[0]=='(') lock.removeAt(0) else return false
                else-> break@loop
            }
        }

    }catch (e:IndexOutOfBoundsException){
        return false
    }
    return lock.isEmpty()
}
private fun recursionOfP(s: String, times: Int, n: Int, list: MutableList<String>) {
    if (times == n) {
        list.add(s)
    } else {
        recursionOfP(s + "(", times + 1, n, list)
        recursionOfP(s + ")", times + 1, n, list)

    }

}

fun main(args: Array<String>) {
    val s = generateParenthesis(3)
    for (c in s) {
        println(c)
    }
}