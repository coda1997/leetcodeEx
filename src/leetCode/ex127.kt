package leetCode

import kotlin.test.assertEquals

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val usedSet = mutableListOf<String>()
    if (!wordList.contains(endWord)) {
        return 0
    }
    var t = 1
    usedSet.add(beginWord)
    while (usedSet.size <= wordList.size) {
        val res = findNe(usedSet, wordList)
        if (res.isEmpty()) {
            break
        }
        if (res.contains(endWord)) {
            return t+1
        } else {
            usedSet.addAll(res)
            t++
        }
    }
    return 0
}

fun findNe(openset: List<String>, wordList: List<String>): List<String> {
    val res = mutableListOf<String>()
    for (i in wordList) {
        if (openset.contains(i)) {
            continue
        } else {
            if (openset.find { isOneDiff(i, it) } != null) {
                res.add(i)
            }
        }
    }
    return res
}

fun isOneDiff(a: String, b: String): Boolean {
    var p = 0
    var diff = 0
    while (p < a.length) {
        if (a[p] != b[p]) {
            diff++
        }
        p++
    }
    return diff == 1
}

fun main() {
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
    assertEquals(5, ladderLength(beginWord, endWord, wordList))
}



