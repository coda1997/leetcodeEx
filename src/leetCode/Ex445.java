package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex445 {

    private Deque<ListNode> stack1 = new LinkedList<>();
    private Deque<ListNode> stack2 = new LinkedList<>();


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var t = l1;
        while(t!=null){
            stack1.push(t);
            t = t.next;
        }
        t = l2;
        while(t!=null){
            stack2.push(t);
            t = t.next;
        }
        var rem = 0;
        ListNode head = null;
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            var t1 = stack1.pop();
            var t2 = stack2.pop();
            var tt = (t1.val+t2.val+rem)%10;
            rem = (t1.val+t2.val+rem)/10;
            if(head==null){
                head = new ListNode(tt);
            }else{
                var temp = new ListNode(tt);
                temp.next = head;
                head = temp;
            }
        }
        while(!stack1.isEmpty()){
            var tt = stack1.pop();
            var temp = (tt.val+rem)%10;
            rem = (tt.val+rem)/10;
            if(head!=null){
                var tl = new ListNode(temp);
                tl.next = head;
                head = tl;
            }else{
                head = new ListNode(temp);
            }
        }
        while(!stack2.isEmpty()){
            var tt = stack2.pop();
            var temp = (tt.val+rem)%10;
            rem = (tt.val+rem)/10;
            if(head!=null){
                var tl = new ListNode(temp);
                tl.next = head;
                head = tl;
            }else{
                head = new ListNode(temp);
            }
        }
        if(rem>0){
            var temp = new ListNode(rem);
            temp.next = head;
            head = temp;
        }

        return head;
    }



}