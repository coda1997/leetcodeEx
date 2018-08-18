package leetCode
class Solution83{

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null){
            return head
        }
        val dump = ListNode(head.`val`-1)
        var cur = head
        var pre = dump
        var temp = dump
        while (cur!=null){
           if (pre.`val`==cur.`val`){

           }
            cur=cur.next
        }
        return dump.next
    }
}

fun main(args: Array<String>) {
    val head = ListNode(1)
    var cur :ListNode?= head
    val arrays = intArrayOf(2,3,3,4,4,5)
    (0 until 6).forEach {
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
