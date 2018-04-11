package leetCode

fun subsets(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    res.add(mutableListOf())
    nums.forEach {num->
        val t = res.size
        (0 until t).forEach {
            val temp = mutableListOf<Int>()
            temp.addAll(res[it])
            temp.add(num)
            res.add(temp)
        }
    }
    return res
}

fun main(args: Array<String>) {
    subsets(intArrayOf(1,2,3)).apply(::println)
}