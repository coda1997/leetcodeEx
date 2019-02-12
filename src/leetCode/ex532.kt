package leetCode

fun findPairs(nums: IntArray, k: Int) = HashMap<Int, Int>().apply {

    val t = nums.sorted()
    t.forEach {
        if (containsKey(it - k)) {
            put(it - k, 1)
        }
        if (!containsKey(it)){
            put(it, 0)
        }
    }

}.values.sum()

fun main(args: Array<String>) {
    findPairs(intArrayOf(3, 1, 4, 1, 5), 0).apply { println(this) }
}
