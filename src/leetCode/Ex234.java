package leetCode;

public class Ex234 {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode s = dummy, l=dummy;
        while(s!=null&&s.next!=null){
            s = s.next.next;
            l = l.next;
        }
        var cur = l.next;
        var pre = l;
        l.next = null;
        while(cur!=null){
            var temp  = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        l = dummy.next;
        while(l!=null&&pre!=null){
            if(l.val!=pre.val){
                return false;
            }
            l = l.next;
            pre = pre.next;
        }
        return true;
    }
}
