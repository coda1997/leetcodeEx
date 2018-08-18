package leetCode

class MinStack() {
    val datas = mutableListOf<Int>()
    val minDatas = mutableListOf<Int>()

    fun push(x: Int) {
        if (minDatas.isEmpty() || x <= minDatas[0]) {
            minDatas.add(0, x)
        }
        datas.add(0, x)
    }

    fun pop() {
        if (datas.isEmpty() || minDatas.isEmpty()) {
            return
        }
        val t = datas[0]
        if (t == minDatas[0]) {
            minDatas.removeAt(0)
        }
        datas.removeAt(0)
    }

    fun top(): Int {
        if (datas.isEmpty()) {
            return 0
        }
        return datas[0]
    }

    fun getMin(): Int {
        if (minDatas.isEmpty()) {
            return 0
        }
        return minDatas[0]
    }
}

fun main(args: Array<String>) {
    var obj = MinStack()
    obj.push(-2)
    obj.push(0)
    obj.push(-3)
    println(obj.getMin())
    obj.pop()
    println(obj.top())
    println(obj.getMin())
}