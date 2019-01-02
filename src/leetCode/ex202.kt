package leetCode

fun isHappy(n: Int): Boolean {
    var res :Int
    var ress: Int
    var temp = n
    val resset = linkedSetOf<Int>()
    while (temp>1){
        res = temp
        temp = 0
        while (res > 0) {
            ress = res % 10
            res /= 10
            temp += ress * ress
        }
        if (resset.contains(temp)) {
            return false
        }
        resset.add(temp)
    }
    return temp == 1
}

fun main(args: Array<String>) {
    print(isHappy(2))
}