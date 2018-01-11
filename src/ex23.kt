private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val head = ListNode(0)
    var temp = head
    while (true){
        temp.next = lists.asSequence().filterNotNull().minBy { it.`val` }
        temp = temp.next?.let { lists[lists.indexOf(temp)] = temp.next;temp.next }?: break
    }
    return head.next
}

