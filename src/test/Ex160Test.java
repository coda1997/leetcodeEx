package test;

import leetCode.Ex160;
import leetCode.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Ex160Test {
    private Ex160 ex160 = new Ex160();
    @Test
    public void testGetIntersectionNode(){
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode inter = new ListNode(3);
        headA.next = inter;
        headB.next = inter;
        inter.next = new ListNode(4);
        ListNode res = ex160.getIntersectionNode(headA,headB);
        Assert.assertEquals(res,inter);
    }

}
