package test;

import leetCode.Ex165;
import org.junit.Assert;
import org.junit.Test;

public class Ex165Test {
    private Ex165 ex165 = new Ex165();
    @Test
    public void testCompareVersion(){
        Assert.assertEquals(ex165.compareVersion("0.1","1.1"),-1);
        Assert.assertEquals(ex165.compareVersion("1.0.1","1"),1);
        Assert.assertEquals(ex165.compareVersion("7.5.2.4","7.5.3"),-1);

    }
}
