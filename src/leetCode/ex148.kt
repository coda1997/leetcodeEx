package leetCode

fun sortList(head: ListNode?): ListNode? {
    if (head==null){
        return null
    }
    var p = head.next
    var ll :ListNode?=null
    var rr :ListNode?=null
    while (p!=null){
        val pp = p.next
        if (p.`val`< head.`val`){
            p.next=ll
            ll=p
        }else{
            p.next=rr
            rr=p
        }
        p = pp
    }
    val l = sortList(ll)
    val r = sortList(rr)
    head.next=r
    return if (l==null){
        head
    }else{
        var pp = l
        while (pp?.next!=null){
            pp=pp.next
        }
        pp?.next= head
        l
    }
}

fun main() {
    val head = ListNode(4)
    head.next = ListNode(2)
    head.next.next = ListNode(1)
    head.next.next.next = ListNode(3)
    var res = sortList(head)
    while (res!=null){
        print("${res.`val`} ")
        res=res.next
    }
    println()
}

