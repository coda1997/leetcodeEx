package leetCode

fun permute(nums: IntArray): List<List<Int>> {
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

        while (i >= 0 && nums[i] > nums[i + 1]) {
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

fun permute2(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    res.add(mutableListOf())
    for (value in nums) {
        for (size in res.size downTo 1) {
            val r = res.removeAt(0)
            for (i in 0..r.size) {
                val t = MutableList(r.size) { r[it] }
                t.add(i, value)
                res.add(t)
            }
        }
    }
    return res
}

fun permute3(nums: IntArray) = mutableListOf<MutableList<Int>>().apply{
    add(mutableListOf())
    nums.forEach { value ->
        (size downTo 1).forEach {
            val r = removeAt(0)
            (0..r.size).forEach { i ->
                add(MutableList(r.size) { r[it] }.apply {
                    add(i, value)
                })
            }
        }
    }

}


fun main(args: Array<String>) {
    permute(intArrayOf(1, 1, 2)).forEach { println(it) }
}