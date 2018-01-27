package LeetCode

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()){
        return ""
    }
    var prefix = strs[0]
    for (str in strs) {
        for ((index,value) in str.withIndex()){
            if (index >= prefix.length || value != prefix[index]) {
                prefix=prefix.substring(0,index)
                break
            }
        }
        if (prefix.length>str.length){
            prefix=prefix.substring(0,str.length)
        }
    }
    return prefix
}

fun main(args: Array<String>) {
    println(longestCommonPrefix(arrayOf("a", "b")))
}