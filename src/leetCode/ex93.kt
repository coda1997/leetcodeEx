package leetCode

fun restoreIpAddresses(s: String): List<String> {
    var res = mutableListOf<String>()
    dfs(3, s, "", res)
    return res
}

fun dfs(k: Int, s: String, temp: String, res: MutableList<String>) {
    if (s.length <= k || s.length > (k + 1) * 3) {
        return
    }
    if (k == 0) {
        if ((s[0]=='0'&&s.length!=1)||s.toInt() > 255) {
            return
        }
        res.add("$temp.$s")
        return
    }
    for (it in 1 ..3){
        if (it < s.length) {
            var tt = s.substring(0, it)
            if (tt.toInt() < 256) {
                val str = s.substring(it)
                if (temp.isNotEmpty()) {
                    tt = "$temp.$tt"
                }
                dfs(k - 1, str, tt, res)
            }
        }
        if (s[0]=='0'){
            break
        }
    }
}

fun main(args: Array<String>) {
    restoreIpAddresses("25525511135").forEach { println(it) }
}