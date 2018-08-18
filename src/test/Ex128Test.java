package test;

import leetCode.Ex128;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class Ex128Test {
    private Ex128 ex128;

    @Before
    public void createTestCase(){
        ex128 = new Ex128();
    }

    @Test
    public void testLongestConsecutive(){
        int[] test1= new int[]{100,4,200,1,3,2};
        int[] test2= new int[]{100,4,200,1,3,2,5};
        int[] test3= new int[]{100,4,200,1,3,2,6};

        assertEquals(ex128.longestConsecutive(test1),4);
        assertEquals(ex128.longestConsecutive(test2),5);
        assertEquals(ex128.longestConsecutive(test3),4);
    }
}
