package leetCode

//TLE
fun findMinHeightTreesDFS(n: Int, edges: Array<IntArray>): List<Int> {
    var min = Int.MAX_VALUE
    val table = findAllEdegs(n, edges)
    val res = mutableListOf<Int>()
    (0 until n).forEach {
        val t = getTreeHeight(it, table)
        if (min > t) {
            min = t
            res.clear()
            res.add(it)
        } else if (min == t) {
            res.add(it)
        }
    }
    return res
}

private fun getTreeHeight(root: Int, table: List<List<Int>>): Int {
    val used = mutableSetOf<Int>()
    var len = 0
    var using = setOf(root)
    do {
        used.addAll(using)
        using = using.flatMap { table[it] }.filter { !used.contains(it) }.toSet()
        len++
    } while (using.isNotEmpty())
    return len
}

private fun findAllEdegs(n: Int, edges: Array<IntArray>) = mutableListOf<MutableList<Int>>().apply {
    (0 until n).forEach {
        add(findEdges(it, edges))
    }
}

private fun findEdges(des: Int, edges: Array<IntArray>) = mutableListOf<Int>().apply {
    edges.forEach {
        when (des) {
            it[0] -> add(it[1])
            it[1] -> add(it[0])
        }
    }
}

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n<3){
        return (0 until n).toList()
    }
    val table = findAllEdegs(n, edges)
    var set:Set<Int>
    val res = mutableListOf<Int>().apply { (0 until n).forEach { add(it) } }
    do {
        set = findLeaves(table).toSet()
        res.removeAll(set)
    } while (res.size>2)
    return res
}

private fun findLeaves(table: MutableList<MutableList<Int>>) = mutableSetOf<Int>().apply {
    table.forEachIndexed { index, mutableList -> if (mutableList.size == 1) add(index)  }
    forEach { it1->
        table[it1].forEach {
            table[it].remove(it1)
        }
        table[it1].clear()
    }
}

fun main(args: Array<String>) {
    findMinHeightTrees(4, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3))).apply { println(this) }
}