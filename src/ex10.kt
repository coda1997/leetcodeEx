fun isMatch(s:String,p:String):Boolean{
    if(p.isEmpty()&&s.isEmpty()) return true
    if(s.isEmpty()&&p.length>1&&p[1]=='*') return isMatch(s,p.substring(2))
    if(p.isEmpty()||s.isEmpty()) return false


    //match the header
    return if(s[0]==p[0]||p[0]=='.'){
        if(p.length>1&&p[1]=='*'){
            isMatch(s.substring(1),p)||isMatch(s,p.substring(2))
        }else{
            isMatch(s.substring(1),p.substring(1))
        }
    }else {
        if(p.length>1&&p[1]=='*'){
            isMatch(s,p.substring(2))
        }else{
            false

        }
    }
}

fun main(args: Array<String>) {
    println(isMatch("aa", "a"))
    println(isMatch("aa", "aa"))
    println(isMatch("aaa", "aa"))
    println(isMatch("aa", "a*"))
    println(isMatch("aa", ".*"))
    println(isMatch("ab", ".*"))
    println(isMatch("aab", "c*a*b*"))
    println(isMatch("a","a*a.*"))


}