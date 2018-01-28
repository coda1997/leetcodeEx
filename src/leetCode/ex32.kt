package leetCode

fun longestValidParentheses(s: String): Int {
    var res = 0
    val stack = mutableListOf<Int>()
    stack.push(-1)
    (0 until s.length).forEach {
        when {
            s[it]=='(' -> stack.push(it)
            else -> {
                stack.pop()
                when {
                    stack.isEmpty() -> stack.push(it)
                    else -> res = Math.max(res,it-stack.peek())
                }
            }
        }
    }
    return res
}
private fun<T> MutableList<T>.push(item:T){
    this.add(0,item)
}
private fun<T> MutableList<T>.pop(){
    this.removeAt(0)
}
private fun <T> MutableList<T>.peek() = this[0]
fun main(args: Array<String>) {
    longestValidParentheses(")(((((()())()()))()(()))(").apply { println(this) }
}