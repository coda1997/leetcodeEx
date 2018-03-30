package leetCode

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var correntHead = head
    var next = if (correntHead!=null) skipKNode(correntHead,k) else null
    var res = reverseNode(correntHead ?: return null, k)

    while (correntHead != null) {
        correntHead = next
        next = if (next!=null) skipKNode(next,k) else null
        res =
            unionNode(res, reverseNode(correntHead ?: return res[0], k))
    }
    return res[0]
}

private fun unionNode(head1: Array<ListNode>, head2: Array<ListNode>): Array<ListNode> {
    head1[1].next = head2[0]
    return arrayOf(head1[0], head2[1])
}

private fun skipKNode(head: ListNode, k: Int): ListNode? {
    var t = head
    (0 until k).forEach {
        t = t.next ?: return null
    }
    return t
}

private fun reverseNode(head: ListNode, n: Int): Array<ListNode> {
    var temp = head
    var pre: ListNode? = null
    var next = temp.next
    if (skipKNode(head,n-1)==null){return arrayOf(head,ListNode(-1))}
    var i = 1
    while (next != null && i < n) {
        if (pre == null) {
            temp.next = null
        } else {
            temp.next = pre
        }
        val t = next.next
        next.next = temp
        pre = temp
        temp = next
        next = t
        i++
    }
    return arrayOf(temp, head)
}

