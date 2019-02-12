package leetCode

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val dummy = ListNode(`val`-1)
    dummy.next = head
    var temp = head
    var prev = dummy
    while (temp != null) {
        if (temp.`val` == `val`){
            prev.next = temp.next
            temp.next = null
            temp = prev.next
        }else{
            prev = temp
            temp = temp.next
        }
    }
    return dummy.next
}