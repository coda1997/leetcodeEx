package course;

public class InsertIntoSortList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(final int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        var dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        var t = head;
        var tp = dummy;
        while(t.next!=null){
            var flag = true;
            while(tp!=t){
                if(t.next.val<tp.next.val){
                    helper(tp, t);
                    flag=false;
                    break;
                }
                tp=tp.next;
            }
            tp=dummy;
            if(flag){
                t=t.next;
            }
        }
        return dummy.next;

    }

    private void helper(ListNode pre, ListNode e){
        var t1 = pre.next;
        var item = e.next;
        e.next = item.next;
        pre.next = item;
        item.next = t1;
    }

    public static void main(final String[] args) {
        final var o = new InsertIntoSortList();
        final var head = o.new ListNode(4);
        head.next = o.new ListNode(2);
        head.next.next = o.new ListNode(1);
        head.next.next.next = o.new ListNode(3);
        o.insertionSortList(head);
    }
}