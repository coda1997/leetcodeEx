package leetCode;

import java.util.LinkedList;

public class Ex143 {
    // space: O(n)
    public void reorderList(ListNode head) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.add(head);
            head=head.next;
        }

        ListNode dump = new ListNode(0);
        while (!linkedList.isEmpty()){
            dump.next=linkedList.removeFirst();
            dump=dump.next;
            if (!linkedList.isEmpty()) {
                dump.next=linkedList.removeLast();
                dump=dump.next;
            }
        }
        dump.next=null;
    }

    //space O(1)
    public void reorderList2(ListNode head){
        var dummy = new ListNode(1);
        dummy.next = head;
        ListNode s =dummy,l = dummy;
        while(s!=null&&s.next!=null){
            s = s.next.next;
            l = l.next;
        }
        //l point to the middle node
        //reverse the right part of the list.
        var cur = l.next;
        var pre= l;
        l.next = null;
        while(cur!=null){
            var temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
        }
        cur = pre;
        //cur is the right head.
        while(head!=null&&cur!=null){
            var temp = head.next;
            var rtemp = cur.next;
            head.next = cur;
            cur.next = temp;
            cur = rtemp;
            head = temp;
        }
        //merge the two header
    }
    public static void main(String[] args) {
        var o = new Ex143();
        var temp = new ListNode(1);
        temp.next = new ListNode(2);
        temp.next.next = new ListNode(3);
        temp.next.next.next = new ListNode(4);
        o.reorderList2(temp);
    }
}
