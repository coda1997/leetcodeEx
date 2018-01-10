/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */

 class ListNode(var `val`: Int = 0) {
         var next: ListNode? = null
     }
   private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var p = head
        val stack = arrayListOf<ListNode>()
        while (p!=null){
            stack.add(0,p)
            p=p.next
        }
        if(n+1>stack.size)
            return head?.next
        stack[n].next= if(n-2>=0) stack[n-2] else null
        return head
    }
