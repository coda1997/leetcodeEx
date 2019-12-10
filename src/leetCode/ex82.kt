package leetCode
class Solution83{

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null){
            return head
        }
        val dump = ListNode(head.`val`-1)
        var cur = head
//        val pre = dump
        while (cur!=null){

            cur=cur.next
        }
        return dump.next
    }
}

fun main(args: Array<String>) {
    val head = ListNode(1)
    var cur :ListNode?= head
    val arrays = intArrayOf(2,3,3,4,4,5)
    for (it in 0 until 6) {
        cur?.next = ListNode(arrays[it])
        cur= cur?.next
    }
    Solution83().deleteDuplicates(head).apply {
        var hh = this
        while (hh!=null){
            println(hh.`val`)
            hh= hh.next
        }
    }
}
