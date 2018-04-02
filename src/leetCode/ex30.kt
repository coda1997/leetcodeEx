package leetCode

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val len = words.sumBy { it.length }
    val res = arrayListOf<Int>()
    val size = words[0].length
    val map = mutableMapOf<String,Int>()
    words.groupBy { it }.forEach { map.put(it.key,it.value.size) }
    (0 .. s.length-len).forEach {
        if (checkSubString(s.substring(it,it+len),map,size)){
            res.add(it)
        }
    }
    return res
}

private fun checkSubString(s:String,words: Map<String,Int>,k:Int):Boolean{
    val temp = mutableMapOf<String,Int>()
    (0 until s.length step k).forEach {
        val key = s.substring(it, it + k)
        if (words.containsKey(key)){
            temp.put(key,temp.getOrDefault(key,0)+1)
            if ((temp[key]?:0) > (words[key] ?:0)){
                return false
            }
        }else{
            return false
        }
    }
    return words.all { temp[it.key]==it.value }
}


