package test;

import leetCode.Ex121;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class Ex121Test {
    private Ex121 ex121;
    @Before
    public void createTestCase(){
        ex121 = new Ex121();
    }

    @Test
    public void testMaxProfit1(){
        int[] t1 = new int[]{7,1,5,3,6,4};
        int[] t2 = new int[]{7,6,4,3,1};

        assertEquals(ex121.maxProfit(t1),5);
        assertEquals(ex121.maxProfit(t2),0);


    }

    @Test
    public void testMaxProfit2(){
        int[] t1= new int[]{7,6,4,3,1};
        int[] t2= new int[]{3,3,5,0,0,3,1,4};
        int[] t3= new int[]{1,2,3,4,5};

        assertEquals(ex121.maxProfit2(t1),0);
        assertEquals(ex121.maxProfit2(t2),6);
        assertEquals(ex121.maxProfit2(t3),4);
    }

}
