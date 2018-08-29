package test;

import leetCode.Ex137;
import org.junit.Assert;
import org.junit.Test;

public class Ex137Test {
    private Ex137 ex137 = new Ex137();

    @Test
    public void testSingleNumber(){
        int[] test = new int[]{2,2,3,2};
        int[] test2 = new int[]{0,1,0,1,0,1,99};

        Assert.assertEquals(ex137.singleNumber(test),3);
        Assert.assertEquals(ex137.singleNumber(test2),99);

    }
}
