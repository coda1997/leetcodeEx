package leetCode

import kotlin.test.assertEquals

fun isValidSerialization(preorder: String): Boolean {
    var t = 1
    for (i in preorder.split(',')) {
        t -= 1
        if (t < 0) {
            return false
        }
        if (i != "#") {
            t += 2
        }

    }
    return t == 0
}

fun main() {
    assertEquals(true, isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
    assertEquals(false, isValidSerialization("1,#"))
}