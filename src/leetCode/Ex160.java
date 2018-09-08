package leetCode;

public class Ex160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA,t2 = headB;
        if (t1 == null || t2 == null) {
            return null;
        }
        while (t1.next!=null){
            t1 = t1.next;
        }
        while (t2.next != null) {
            t2 = t2.next;
        }
        if (t1!=t2){
            return null;
        }
        t1.next = headA;
        ListNode res = getLoopEntryNode(headB);
        t1.next=null;
        return res;
    }
    private ListNode getLoopEntryNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        do{
            fast=fast.next.next;
            slow = slow.next;
        }while (fast !=slow);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
