package leetCode

fun sortedListToBST(head: ListNode?): TreeNode? {
    var length = 0
    var temp: ListNode? = head
    while (temp != null) {
        temp = temp.next
        length++
    }
    return sortedListToBST(head, length)
}

fun sortedListToBST(head: ListNode?, length: Int): TreeNode? {
    if (length == 1) {
        return TreeNode(head!!.`val`)
    } else if (length == 0) {
        return null
    }
    val mid = length / 2
    val left = sortedListToBST(head, mid)
    val t = findByIndex(head, mid)
    val right = sortedListToBST(t.next, length - mid - 1)
    val root = TreeNode(t.`val`)
    root.left = left
    root.right = right
    return root
}

// index start from 0
fun findByIndex(head: ListNode?, index: Int): ListNode {
    var t = index
    var temp = head
    while (t > 0 && temp != null) {
        t--
        temp = temp.next
    }
    return temp!!
}


fun main() {
    val head = ListNode(-10)
    head.next = ListNode(-3)
    head.next.next = ListNode(0)
    head.next.next.next = ListNode(5)
    head.next.next.next.next = ListNode(9)
    sortedListToBST(head)

}