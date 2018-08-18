package leetCode

/**
 * Definition for singly-linked list.
 * class leetCode.leetCode.ListNode(var `val`: Int = 0) {
 *     var next: leetCode.leetCode.ListNode? = null
 * }
 */
fun swapPairs(head: ListNode?): ListNode? {
    var p1 = head
    var p: ListNode?
    var p2: ListNode?
    val headd: ListNode?
    p2 = p1?.next ?: return head
    p1.next = p2.next
    headd = p2
    p2.next = p1
    p = p1
    p1 = p1.next
    while (true) {
        p2 = p1?.next ?: break
        p?.next = p2
        p1?.next = p2.next
        p2.next = p1
        p = p1
        p1 = p1?.next
    }
    return headd
}
