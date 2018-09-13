package test;

import leetCode.Ex151;
import org.junit.Assert;
import org.junit.Test;

public class Ex151Test {
    private Ex151 ex151 = new Ex151();
    @Test
    public void testReverseWords(){
        String test1 = "the sky is blue";
        String test2 = "the  sky is  blue";
        Assert.assertEquals("blue is sky the",ex151.reverseWords(test1));
        Assert.assertEquals("blue is sky the",ex151.reverseWords(test2));
        Assert.assertEquals("",ex151.reverseWords("    "));
    }

}
