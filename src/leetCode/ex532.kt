package leetCode

fun findPairs(nums: IntArray, k: Int) = HashMap<Int,Int>().apply {

    nums.sorted()
    nums.forEach { if (containsKey(it-k)) put(it-k,1) else put(it,0) }

}.values.sum()

fun main(args: Array<String>) {
    findPairs(intArrayOf(1,1,1,1,1),0).apply { println(this) }
}
