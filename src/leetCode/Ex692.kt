package leetCode

fun topKFrequent(words:Array<String>, k:Int ):List<String> = HashMap<String, Int>().apply {
    words.forEach { this[it] = this.getOrDefault(it,0)+1 }
}.entries.sortedWith{ o1, o2->
    if (o1.value == o2.value) {
        o1.key.compareTo(o2.key)
    }else{
        o2.value-o1.value
    }
}.subList(0,k).map { it.key }
