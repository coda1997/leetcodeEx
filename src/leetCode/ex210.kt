package leetCode

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    if (prerequisites.isEmpty()) return (0 until numCourses).toList().toIntArray()
    val visited = BooleanArray(numCourses){false}
    val res = mutableListOf<Int>()
    var set: Set<Int>
    do {
        set= getDep(numCourses,prerequisites,visited)
        res.addAll(set.toList())
    }while (set.isNotEmpty())
    return if (prerequisites.all { it.isEmpty() }) res.toIntArray() else intArrayOf()

}


private fun getDep(numCourses: Int, prerequisites: Array<IntArray>,visited:BooleanArray) = mutableSetOf<Int>().apply {
    val dep = prerequisites.filter { it.isNotEmpty() }.map { it[0] }.toSet()
    (0 until numCourses).filterNot { visited[it]||dep.contains(it) }.forEach { add(it);visited[it]=true }
    (0 until prerequisites.size)
            .filter { prerequisites[it].isNotEmpty() && contains(prerequisites[it][1]) }
            .forEach { prerequisites[it]= intArrayOf() }
}