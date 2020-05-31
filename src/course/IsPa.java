package course;

import leetCode.ListNode;

public class IsPa {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        var dummy = new ListNode(-1);
        dummy.next = head;
        var fast = dummy;
        var slow = dummy;
        while(fast.next!=null){
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        var right = reverseNodeAfter(slow);
        var temp = right;
        var left = head;
        while(left!=null){
            if(left.val!=right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        
        //restore the linked list
        //reverseNodeAfter(temp);
        return true;
    }
    
    private ListNode reverseNodeAfter(ListNode head){//head.next is the beginning node.
        var t = head.next;
        var pre = head;
        pre.next = null;
        while(t!=null){
            var tt = t.next;
            t.next = pre;
            pre = t;
            t = tt;
        }//if t equals none, pre is the last node.
        return pre;
    }

    public static void main(String[] args) {
        var o = new IsPa();
        var head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(o.isPalindrome(head));
    }
    
}