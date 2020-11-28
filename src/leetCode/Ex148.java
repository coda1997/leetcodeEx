package leetCode;

public class Ex148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head);
    }

    ListNode dummy = new ListNode(0);

    private ListNode helper(ListNode head) {
        if (head.next == null) {
            return head;
        }
        dummy.next = head;
        ListNode slow, fast;
        slow = fast = dummy;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;

            }
        }
        var temp = slow.next;
        slow.next = null;
        var l = helper(head);
        var r = helper(temp);
        return merge(l, r);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        dummy.next = null;
        var cur = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if (h1 != null) {
            cur.next = h1;
        }
        if (h2 != null) {
            cur.next = h2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        var head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        var o = new Ex148();
        var res = o.sortList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
