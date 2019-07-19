package leetCode

fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var current = head
    var next = head.next
    current.next = null
    while (next != null) {
        val temp = next.next
        next.next=current
        current=next
        next = temp
    }


    return current
}

fun main(args: Array<String>) {
    val temp = ListNode(1)
    temp.next = ListNode(2)
    temp.next.next = ListNode(3)
    val res = reverseList(temp)
    print(res?.`val`)
}