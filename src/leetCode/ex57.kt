package leetCode

fun insert(intervals: List<Interval>, newInterval: Interval) = merge2(mutableListOf<Interval>().apply {
    addAll(intervals);add(newInterval)
})
private fun merge2(intervals: List<Interval>): List<Interval> {
    if (intervals.isEmpty()) return listOf()
    fun mergeIntervals(l: Interval, r: Interval) {
        if (l.end < r.end)
            l.end = r.end
    }
    //initialization a stack through kotlin hasn't contain
    val res = mutableListOf<Interval>()
    val int = intervals.sortedBy { it.start }
    res.add(int[0])
    (1 until int.size).forEach { index ->
        when {
            res[res.size - 1].end >= int[index].start -> mergeIntervals(res[res.size - 1], int[index])
            else -> res.add(int[index])
        }
    }
    return res
}

fun main(args: Array<String>) {
    insert(listOf(Interval(1,5)),Interval(2,3)).forEach { println("${it.start} : ${it.end}") }
}