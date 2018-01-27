package LeetCode

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if(head==null||k==1){
        return head
    }

    val fake = ListNode(0)
    fake.next=head
    var pre = fake
    var p: ListNode? = head
    var i  = 0
    while (p!=null){
        i++
        if (i%k==0){
            pre = reverse(pre, p.next ?: return fake.next)
            p = pre.next
        }else{
            p = p.next
        }
    }
    return fake.next
}

private fun reverse(pre: ListNode, next: ListNode): ListNode {
    val last = pre.next
    var curr = last?.next
    while (curr!=last){
        last?.next=curr?.next
        curr?.next=pre.next
        pre.next=curr
        curr=last?.next
    }
    return last!!

}

