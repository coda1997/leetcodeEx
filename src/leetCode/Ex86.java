package leetCode;

public class Ex86 {


    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dump = new ListNode(x - 1);
        dump.next = head;
        ListNode bigHead = null;
        ListNode current = dump;
        while (current!=null&&current.next != null) {
            if (current.next.val >= x) {
                if (bigHead == null) {
                    bigHead = current;
                }
                current = current.next;
            } else {
                if (bigHead!=null){

                    ListNode temp = current.next;
                    current.next = current.next.next;
                    ListNode temp2 = bigHead.next;
                    bigHead.next = temp;
                    temp.next = temp2;
                    bigHead=temp;
                }else {

                    current = current.next;
                }
            }
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode t = new ListNode(2);
        t.next=new ListNode(1);
        ListNode t2=new Ex86().partition(t,2);
    }
}
