package leetCode;

public class Ex147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode pre = head;
        var cur = head.next;        
        var temp = head;
        ListNode tpre = null;
        while(cur!=null){
            tpre=null;
            temp = head;
            while(temp!=null&&temp.val<cur.val){
                tpre = temp;
                temp = temp.next;
            }
            pre = cur;
            cur = cur.next;
            if(tpre==null){
                pre.next = head;
                head = pre;
            }else{
                tpre.next = pre;
                pre.next = temp;
            }
        }
        return head;
    }
}
