package leetCode

fun combine(n: Int, k: Int): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    combineDfs(mutableListOf(),res,0,k,n,0)
    return res
}

private fun combineDfs(list:MutableList<Int>,result:MutableList<MutableList<Int>>,k:Int,target:Int,n:Int,item:Int){
    if (k==target){
        result.add(mutableListOf<Int>().apply { addAll(list) })
    }
    (item+1 .. n ).forEach {
        list.add(it)
        combineDfs(list,result,k+1,target,n,it)
        list.remove(it)
    }
}

fun main(args: Array<String>) {
    combine(4,2).forEach { println(it) }
}