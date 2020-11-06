package leetCode

fun sortByBits(arr: IntArray): IntArray {
    val bits = IntArray(10001)
    bits.forEachIndexed { index, _ ->
        bits[index] = bits[index.shr(1)]+index.and(1)
    }
    return arr.sortedWith(Comparator { x, y ->
        if(bits[x]!=bits[y]){
            return@Comparator bits[x]-bits[y]
        }else{
            return@Comparator x-y
        }
    }).toIntArray()
}

