package leetCode

fun containsDuplicate(nums: IntArray): Boolean {
    val hash = hashSetOf<Int>()
    nums.forEach {
        if (hash.contains(it)) {
            return true
        }else{
            hash.add(it)
        }
    }
    return false
}