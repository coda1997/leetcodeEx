package leetCode

import kotlin.test.assertEquals

fun numDistinct(s: String, t: String): Int {
    val tt = List(t.length+1){
        IntArray(s.length+1)
    }
    for (j in tt.indices){
        for (i in tt[j].indices){
            if (j==0){
                tt[j][i]=1
            }else{
                if (i==0){
                    continue
                }
                if (s[i-1]==t[j-1]){
                    tt[j][i]=tt[j-1][i-1]+tt[j][i-1]
                }else{
                    tt[j][i]=tt[j][i-1]
                }
            }
        }
    }
    return tt[t.length][s.length]
}

fun main() {
    assertEquals(3, numDistinct("rabbbit", "rabbit"))
    assertEquals(5, numDistinct("babgbag", "bag"))
}