package test;

import leetCode.Ex164;
import org.junit.Assert;
import org.junit.Test;

public class Ex164Test {
    private Ex164 ex164 = new Ex164();
    @Test
    public void testMaximunGap(){
        Assert.assertEquals(ex164.maximumGap(new int[]{3,6,9,1}),3);
        Assert.assertEquals(ex164.maximumGap(new int[]{10}),0);
    }

}
