package leetCode;

public class Ex141 {

    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && s != null) {
            f = f.next;
            if (f != null) {
                f = f.next;
            } else {
                return false;
            }
            s = s.next;
            if (f == s) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null) {
            f = f.next;
            if (f != null) {
                f = f.next;
            } else {
                return null;
            }
            s = s.next;
            if (f == s) {
                break;
            }
        }
        if (f == null) {
            return null;
        }
        s = head;
        do {
            if (s==f){
                break;

            }
            s=s.next;f=f.next;
        }while (true);
        return f;
    }
}
