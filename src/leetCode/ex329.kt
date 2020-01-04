package leetCode

fun intersection(nums1: IntArray, nums2: IntArray): IntArray = if (nums1.size>nums2.size){
        nums2.filter { nums1.contains(it) }.distinct().toIntArray()
    }else{
        nums1.filter { nums2.contains(it) }.distinct().toIntArray()
    }
