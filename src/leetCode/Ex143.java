package leetCode;

import java.util.LinkedList;

public class Ex143 {

    public void reorderList(ListNode head) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.add(head);
            head=head.next;
        }

        ListNode dump = new ListNode(0);
        ListNode res = dump;
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
}
