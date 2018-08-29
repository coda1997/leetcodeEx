package test;

import leetCode.Ex135;
import org.junit.Assert;
import org.junit.Test;

public class Ex135Test {
    private Ex135 ex135 = new Ex135();

    @Test
    public void testCandy(){
        int[] test1 = new int[]{1,0,2};
        int[] test2 = new int[]{1, 2, 2};

//        Assert.assertEquals(ex135.candy(test1),5);
//        Assert.assertEquals(ex135.candy(test2),4);
        Assert.assertEquals(ex135.candy(new int[]{1,3,4,5,2}),11);
    }
}
