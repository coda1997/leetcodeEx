package leetCode

fun isNumber(s: String): Boolean {
    var index = 0
    for (c in s) {
        if (c.isDigit()||c=='.') {
            index = s.indexOf(c)
            break
        }else if (c!=' '){
            return false
        }
    }
    var dotflag = false
    var expflag = false
    var spacefalg = false
    var haveNum = false
    (index until s.length).forEach {
        if (spacefalg&&s[it]!=' ') return false
        if (!s[it].isDigit()) {
            if (s[it] != 'e' && s[it] != '.' && s[it] != ' ') {
                return false
            }
            if (s[it] == ' ') {
                spacefalg = true
            } else {
                if (s[it] == 'e' && expflag) {
                    return false
                } else if (s[it] == '.' && (dotflag||expflag)) {
                    return false
                }
                if (s[it] == 'e') {
                    if (it+1==s.length||!s[it+1].isDigit()){
                        return false
                    }
                    if (!haveNum) return false
                    expflag = true
                } else {
                    dotflag = true
                }
            }
        } else {
            haveNum=true
            if (spacefalg) {
                return false
            }
        }
    }
    return haveNum

}

fun main(args: Array<String>) {
    isNumber("e9").apply { println(this) }
    isNumber(" .1 ").apply { println(this) }
    isNumber("abc").apply { println(this) }
    isNumber("1 a").apply { println(this) }
    isNumber("2e10").apply { println(this) }
    isNumber("2e").apply { println(this) }
    isNumber("2 .").apply { println(this) }
}