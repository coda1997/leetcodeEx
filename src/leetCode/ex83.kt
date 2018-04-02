package leetCode

fun deleteDuplicates(head: ListNode?): ListNode? {
    var pre: ListNode? = head
    var current: ListNode? = head?.next
    while (current != null) {
        if (pre == null) {
            break
        }
        if (current.`val` == pre.`val`) {
            pre.next = current.next
        } else {

            pre = current
        }
        current = current.next
    }
    return head
}