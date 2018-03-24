package leetCode

import java.io.StringBufferInputStream

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val tokens = words.flatMap {  it.split(" ") }
    var len = 0
    var left = 0
    val results = mutableListOf<String>()
    for((i,token) in tokens.withIndex()){
        len+=token.length
        if (len>maxWidth){
            len -= token.length
            val spaceNum = maxWidth-len
            val spaceEach = spaceNum/(i-left)
            var s= tokens[left]
            (1 until i-left).forEach {
                (0 until spaceEach+if (it==1) spaceNum%(i-left) else 0).forEach {
                    s+=" "
                }
                s+=tokens[left+it]
            }
            results.add(s)
            left = i
            len = token.length
        }
    }
    val space =if (tokens.size-1-left!=0) (maxWidth-len)/(tokens.size-1-left) else maxWidth-len
    var s= tokens[left]
    (1 until tokens.size-1-left).forEach {
        (0 until space+if (it==1) space%(tokens.size-1-left) else 0).forEach {
            s+=" "
        }
        s +=tokens[left+it]
    }
    if (tokens.size-1-left==0 ) s=s.padEnd(space,' ')
    results.add(s)
    return  results
}

fun main(args: Array<String>) {
    fullJustify(arrayOf("The array of yours","Hello world"),9).forEach { println(it) }
}