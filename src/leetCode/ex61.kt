package leetCode


fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head
    val dump = ListNode()
    dump.next = head

    var t1 = head
    var t2 = head
    var len = 1
    while (t1?.next != null) {
        t1 = t1.next
        len++
    }
    val kk = k % len
    for (i in 0 until len - kk - 1) {
        t2 = t2?.next
    }
    dump.next = t2?.next
    t2?.next = null
    t1?.next = head
    return dump.next
}


fun main(args: Array<String>) {
    val start = ListNode(1)
    start.next = ListNode(2)
    start.next?.next = ListNode(3)
    rotateRight(start, 1).apply {
        var t = this
        while (t != null) {
            println(t.`val`)
            t = t.next
        }
    }
}