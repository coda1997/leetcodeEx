package LeetCode

fun twoSum(nums: IntArray, target: Int): IntArray {
    val valueTable: HashMap<Int, Int> = HashMap()
    for ((i, value) in nums.withIndex()) {
        if (valueTable.containsKey(target - value)) {
            return intArrayOf(valueTable.get(target - value) ?: 0, i)
        } else {
            valueTable.put(value, i)
        }
    }
    return null!!
}


