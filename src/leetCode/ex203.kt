package leetCode

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val dummy = ListNode(`val` - 1)
    dummy.next = head
    var cur: ListNode? = dummy
    while (cur?.next != null) {
        if (cur.next.`val` == `val`) {
            val t = cur.next.next
            cur.next = t
        } else {
            cur = cur.next
        }
    }

    return dummy.next
}

fun main(args: Array<String>) {
    val head = ListNode(1)
    head.next = ListNode(1)
    removeElements(head, 1).apply {
        var cur = this
        while (cur != null) {
            print(cur.`val`)
            cur = cur.next
        }

    }
}