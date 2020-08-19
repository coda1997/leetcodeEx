package course;

import leetCode.ListNode;
/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        var p = head;
        ListNode lp = null, l = null,rp = null, r = null;
        var isOdd = true;
        while(p!=null){
            if(isOdd){
                if(lp==null){
                    lp = l = p;
                }else{
                    l.next = p;
                    l = p;
                }
                isOdd = false;
            }else{
                if(rp==null){
                    rp = r = p;
                }else{
                    r.next = p;
                    r = p;
                }
                isOdd = true;
            }
            p = p.next;
        }
        if(l!=null){
            l.next = rp;
        }
        if(r!=null){
            r.next = null;
        }
        return lp;
    }
}