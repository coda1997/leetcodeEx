package leetCode

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val valueTable: HashMap<Int, Int> = HashMap()
    for ((i, value) in nums.withIndex()) {
        if (valueTable.containsKey(target - value)) {
            return intArrayOf(valueTable[target - value] ?: 0, i)
        } else {
            valueTable[value] = i
        }
    }
    return intArrayOf()
}

fun main(args: Array<String>) {
    println("hello world")
    mutableListOf(1,2).apply{
        add(3)
    }.forEach{
        println(it)
    }
}