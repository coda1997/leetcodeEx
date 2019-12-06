package leetCode

import kotlin.test.assertEquals

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    if (s.isEmpty()){
        return false
    }
    val tt = IntArray(s.length+1)
    tt[0]=1
    for (i in s.indices){
        for (k in i downTo 0){
            val t = s.substring(k,i+1)
            if (tt[k]==1&&wordDict.contains(t)){
                tt[i+1]=1
                break
            }
        }
    }
    return tt[s.length]==1
}

fun main() {
    assertEquals(true, wordBreak("leetcode", listOf("leet","code")))
    assertEquals(true, wordBreak("applepenapple", listOf("apple","pen")))
    assertEquals(false, wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
}