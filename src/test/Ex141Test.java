package test;
import leetCode.Ex141;
import leetCode.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class Ex141Test {

    private Ex141 ex141;

    @Before
    public void createTestCase(){
        ex141 = new Ex141();
    }

    @Test
    public void testHasCycle(){
        ListNode test1 = new ListNode(1);
        assertTrue(ex141.hasCycle(test1));
    }
}
