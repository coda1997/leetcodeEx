package leetCode;

public class Ex61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode dump = new ListNode(0);
        dump.next=(head);
        //t1 is the tail
        while (head.next != null) {
            len++;

        }
        int kk = k % len;
        if (kk == 0) {
            return head;
        }
//        for (int i = 0; i < len - kk - 1; i++) {
//
//        }
        dump.next= head.next;
        head.next=(null);
        head.next=(head);
        return dump.next;
    }
}
