/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var fake = ListNode(0)
    val res = fake
    var p1 = l1
    var p2 = l2
    while (p1 != null && p2 != null) {
        if (p1.`val` > p2.`val`) {
            fake.next = p2
            p2 = p2.next
            fake= fake.next!!
        } else {
            fake.next = p1
            p1 = p1.next
            fake= fake.next!!
        }
    }
    if (p1 == null) {
        fake.next = p2
    }
    if (p2 == null) {
        fake.next = p1
    }
    return res.next
}
