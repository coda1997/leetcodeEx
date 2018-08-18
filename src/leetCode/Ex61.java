package leetCode;

public class Ex61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        int len = 1;
        ListNode dump = new ListNode(0);
        dump.setNext(head);
        ListNode t1 = head;
        ListNode t2 = head;
        //t1 is the tail
        while (t1.getNext() != null) {
            len++;
            t1.setNext(t1.getNext());
        }
        int kk = k % len;
        if (kk == 0) {
            return head;
        }
        for (int i = 0; i < len - kk - 1; i++) {
            t2.setNext(t2.getNext());
        }
        dump.setNext(t2.getNext());
        t2.setNext(null);
        t1.setNext(head);
        return dump.getNext();
    }
}
