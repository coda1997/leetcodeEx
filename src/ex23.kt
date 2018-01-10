private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val head = ListNode(0)
    var temp = head
    while (true) {
        temp.next=lists.asSequence().filterNotNull().minBy { it.`val` }
        if(temp.next!=null){
            temp=temp.next!!
            lists[lists.indexOf(temp)]=temp.next
        }else break

    }
    return head.next
}

