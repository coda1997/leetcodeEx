
fun isPalidrome(P:Array<Array<Boolean>>, s:String, i:Int, j:Int):Boolean=when{
        i==j-> {
            P[i][j]=true
            true
        }
        i+1==j-> {
            P[i][j]=(s[i]==s[j])
            P[i][j]
        }
        else-> {
            P[i][j]=P[i+1][j-1]&&s[i]==s[j]
            P[i][j]
        }
    }


fun longestPalindrome(s: String): String {
    val P = Array(s.length) { Array(s.length) { false } }
    var res:String=""
    for (m in 0 until s.length) {
        for(i in 0 until s.length-m){
            if (isPalidrome(P, s, i, i + m)) {
                res=s.substring(i,i+m+1)
            }
        }
    }

    return res
}

fun display(P:Array<Array<Boolean>>){
    for( i in P){
        for( j in i){
            print(if (j){ "T"}else {"F"}+" ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    println(longestPalindrome("babad"))
}