package test;

import leetCode.Ex134;
import org.junit.Assert;
import org.junit.Test;

public class Ex134Test {
    private Ex134 ex134 = new Ex134();

    @Test
    public void testCanCompleteCircuit(){
        Assert.assertEquals(ex134.canCompleteCircuit(new int[]{
                1,2,3,4,5
        },new int[]{
                3,4,5,1,2
        }),3);

        Assert.assertEquals(ex134.canCompleteCircuit(new int[]{
                2,3,4
        },new int[]{
                3,4,3
        }),-1);

    }
}
