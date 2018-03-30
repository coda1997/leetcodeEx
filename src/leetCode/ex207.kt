package leetCode

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    if (prerequisites.isEmpty()) return true
    val visited = BooleanArray(numCourses){false}
    var set: Set<Int>
    do {
        set= getDep(numCourses,prerequisites,visited)
    }while (set.isNotEmpty())
    return prerequisites.all { it.isEmpty() }
}

private fun getDep(numCourses: Int, prerequisites: Array<IntArray>,visited:BooleanArray) = mutableSetOf<Int>().apply {
    val dep = prerequisites.filter { it.isNotEmpty() }.map { it[0] }.toSet()
    (0 until numCourses).filterNot { visited[it]||dep.contains(it) }.forEach { add(it);visited[it]=true }
    (0 until prerequisites.size)
            .filter { prerequisites[it].isNotEmpty() && contains(prerequisites[it][1]) }
            .forEach { prerequisites[it]= intArrayOf() }
}

fun main(args: Array<String>) {
    canFinish(3, arrayOf(intArrayOf(1, 0), intArrayOf(1,2), intArrayOf(0,1)) ).apply { println(this) }
    println(arrayListOf<IntArray>().any { it.isEmpty() })
}