package leetCode

private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val m: Int
    val n: Int
    val l: IntArray
    val r: IntArray
    //to make sure m<=n and l is the short one, r is the longer one
    if (nums1.size > nums2.size) {
        m = nums2.size
        l = nums2
        n = nums1.size
        r = nums1
    } else {
        m = nums1.size
        l = nums1
        n = nums2.size
        r = nums2
    }
    var iMin = 0
    var iMax = m
    val halfLen = (m + n + 1) / 2
    while (iMin <= iMax) {
        val i = (iMin + iMax) / 2
        val j = halfLen - i
        if (i < iMax && r[j - 1] > l[i]) {
            iMin++
        } else if (i in 1..(iMax - 1) && l[i - 1] > r[j]) {
            iMax--
        }else {
            val maxleft = when {
                i == 0 -> r[j - 1]
                j == 0 -> l[i - 1]
                else -> Math.max(r[j - 1], l[i - 1])
            }
            if ((m + n) % 2 == 1) return maxleft.toDouble()

            val minRight = when {
                i == m -> r[j]
                j == n -> l[i]
                else -> Math.min(r[j], l[i])
            }
            return (maxleft + minRight) / 2.0
        }

    }
    return 0.0
}
