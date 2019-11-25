package leetCode

import java.lang.StringBuilder
import java.util.*

fun removeDuplicateLetters(s: String): String {
    val stack = Stack<Char>()
    var i = 0
    while (i<s.length){
        if (stack.isEmpty()){
            stack.push(s[i])
            i++
            continue
        }
        val t = stack.peek()
        val e = s[i]
        if (e.toInt()>t.toInt()){
            stack.push(e)
            i++
        }else{
            if (s.indexOfLast { it==t }>=i){
                stack.pop()
            }
        }
    }
    val res = StringBuilder()
    while (stack.isNotEmpty()){
        res.append(0,stack.pop())
    }
    return res.toString()
}

fun main() {
    removeDuplicateLetters("bcabc").apply { println(this) }
}