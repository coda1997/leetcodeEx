package leetCode

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    return dfs(candidates.sorted().toIntArray(),target).distinctBy {
        it.toHash()
    }
}

private fun List<Int>.toHash():Int{
    var res = 1
    forEach { res *=it.hashCode()+3 }
    return res+size
}

private fun dfs(candidates: IntArray,target: Int):MutableList<MutableList<Int>>{
    val res = mutableListOf<MutableList<Int>>()
    candidates.filter { it==target }.forEach { res.add(mutableListOf(it)) }
    candidates.filter { target-it>0 }.forEach { item->
        res.addAll(dfs(candidates,target-item).apply {
            forEach { it.add(item) }
        })
    }
    return res
}

fun main(args: Array<String>) {
    combinationSum(intArrayOf(4,2,8),8).forEach { println(it) }
}