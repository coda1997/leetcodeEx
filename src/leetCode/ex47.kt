package leetCode

fun permuteUnique(nums: IntArray): List<List<Int>> {
    if (nums.size < 2) {
        return listOf(nums.toList())
    }
    fun exchange(nums: IntArray, left: Int, right: Int) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
    }

    fun reverse(nums: IntArray, start: Int) {
        (0 until (nums.size - start) / 2).forEach {
            exchange(nums, start + it, nums.size - 1 - it)
        }
    }

    fun next(nums: IntArray): IntArray {
        var i = nums.size - 2

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--
        }
        when (i) {
            -1 -> reverse(nums, 0)
            nums.size - 2 -> reverse(nums, i)
            else -> {
                var j = i + 1
                while (j < nums.size && nums[i] < nums[j]) {
                    j++
                }
                exchange(nums, i, j - 1)
                reverse(nums, i + 1)
            }
        }
        return nums
    }

    val res = mutableListOf<List<Int>>()
    var next = nums
    do {
        res.add(next.toList())
        next = next(next.clone())
    } while (!next.contentEqualsOrdered(nums))
    return res
}

private fun IntArray.contentEqualsOrdered(nums: IntArray): Boolean {
    if (nums.size != size)
        return false
    forEachIndexed { index, value ->
        if (nums[index] != value)
            return false
    }
    return true
}