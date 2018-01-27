package LeetCode

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val res = mutableSetOf<List<Int>>()
    nums.sort()
    var i = 0
    while (i < nums.size - 3) {
        var j = i+1
        while (j < nums.size - 2) {
            var left = j + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[j] + nums[left] + nums[right]
                when {
                    sum == target -> {
                        res.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        left++
                        right--
                    }
                    sum < target -> left++
                    else -> right--
                }

            }
            j++
        }
        i++
    }
    return res.toList()
}
