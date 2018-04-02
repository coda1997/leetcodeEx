package leetCode


fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (k==0||head?.next==null) return head
    var p1 = head
    var p2 = head

    var t = 0
    while (p1!=null&&t<k){
        p1=p1.next
        t++
    }
    while (p1?.next!=null&&p2!=null){
        p1= p1.next
        p2= p2.next
    }
    if (p1==null) return head
    val res = p2?.next
    p2?.next=null
    p1.next=head

    return res
}


fun main(args: Array<String>) {
    val start = ListNode(0)
    val mid= ListNode(1)
    start.next=mid
    mid.next=ListNode(2)
    rotateRight(start,1).apply { println(this!!.`val`) }
}