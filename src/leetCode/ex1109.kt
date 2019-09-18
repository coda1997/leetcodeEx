package leetCode

fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val res = IntArray(n)
    bookings.forEach {
        val i = it[0]
        val j = it[1]
        val k = it[2]
        for (t in i..j){
            res[t-1]+=k
        }
    }
    return res
}

fun main() {
    val bookings = arrayOf(intArrayOf(1,2,10), intArrayOf(2,3,20), intArrayOf(2,5,25))
    corpFlightBookings(bookings, 5).joinToString { "$it" }.apply { println(this) }
}