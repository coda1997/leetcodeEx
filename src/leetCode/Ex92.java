package leetCode;

public class Ex92 {

    private ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null){
            return head;
        }

        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode cur = head;
        ListNode pre = dump;
        int i = 1;
        while (cur!=null&&i<m){
            cur = cur.next;
            pre = pre.next;
            i++;
        }
        if (cur==null){
            return head;
        }
        ListNode tt = cur;
        cur=cur.next;
        i++;
        while (cur!=null&&i<=n){
            ListNode temp = cur.next;
            cur.next=tt;
            tt=cur;
            cur=temp;
            i++;
        }

        pre.next.next=cur;
        pre.next=tt;

        return dump.next;
    }

    public static void main(String[] args) {
        Ex92 ex92 = new Ex92();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int i =2;
        do{
            cur.next = new ListNode(i++);
            cur=cur.next;
        }while (i<6);
        ex92.reverseBetween(head,2,4);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }

    }
}

