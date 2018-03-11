package leetCode


fun rotateRight(head: ListNode?, k: Int): ListNode? {
    var header = head
    var res: ListNode? = null
    var i = 0
    while (header?.next != null) {
        header = header.next
        if (i == k) {
            res = header
        }
        i++
    }
    header?.next = head
    return res
}


fun main(args: Array<String>) {
    val start = ListNode(0)
    val mid= ListNode(1)
    start.next=mid
    mid.next=ListNode(2)
    rotateRight(start,1).apply { println(this!!.`val`) }
}