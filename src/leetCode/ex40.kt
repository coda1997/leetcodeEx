package leetCode


fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    return dfs(candidates.sorted().toIntArray(),target,candidates.size).distinctBy {
        it.toHash()
    }
}
private fun List<Int>.toHash():Int{
    sorted()
    var res = 1
    forEach{
        res*= it+7
    }
    return res
}

private fun dfs(candidates: IntArray,target: Int,end:Int):MutableList<MutableList<Int>>{
    val res = mutableListOf<MutableList<Int>>()
    candidates.filterIndexed { index,it->index<end&&it==target }.forEach { res.add(mutableListOf(it)) }
    candidates.filterIndexed { index, it ->  index<end&& target-it>0 }.forEachIndexed { index, item->
        res.addAll(dfs(candidates,target-item,index).apply {
            forEach { it.add(item) }
        })
    }
    return res
}

fun main(args: Array<String>) {
    intArrayOf(1,1,1,3,3).groupBy { it }.forEach{ println("key= ${it.key} value= ${it.value.size}")}
    combinationSum2(intArrayOf(10,1,2,7,6,1,5),8).forEach { println(it) }
}