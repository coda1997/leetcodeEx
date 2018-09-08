package test;

import leetCode.Ex162;
import org.junit.Assert;
import org.junit.Test;

public class Ex162Test {
    private Ex162 ex162 = new Ex162();
    @Test
    public void testFindPeakElement(){
        int[] test1 = new int[]{1, 2, 3, 1};
        int[] test2 = new int[]{1, 2, 1, 3, 5, 6, 4};
        Assert.assertEquals(ex162.findPeakElement(new int[]{1,2,3}),2);
        Assert.assertEquals(ex162.findPeakElement(test1),2);
        Assert.assertEquals(ex162.findPeakElement(test2),5);
        Assert.assertEquals(ex162.findPeakElement(new int[]{2,1}),0);
        Assert.assertEquals(ex162.findPeakElement(new int[]{1,2}),1);

    }
}
