package leetCode

fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    var p = 0
    val hashMap = hashMapOf<Int, Int>()
    arr1.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0)+1
    }
    arr2.forEach {
        val time = hashMap[it] ?: 0
        for (i in 0 until time) {
            arr1[p + i] = it
        }
        p += time
        hashMap[it] = -1
    }
    hashMap.filterValues { it!=-1 }.keys.sorted().forEach { key->
        val time = hashMap[key] ?: 0
        for (i in 0 until time){
            arr1[p+i] = key
        }
        p += time
    }
    return arr1
}

fun main(args: Array<String>) {
    val arr1 = intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19)
    val arr2 = intArrayOf(2, 1, 4, 3, 9, 6)

    relativeSortArray(arr1, arr2).joinToString { "${it}" }.apply { println(this) }
}