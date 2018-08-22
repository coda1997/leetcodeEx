package test;

import leetCode.Ex150;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Ex150Test {

    private Ex150 ex150;

    @Before
    public void createTestCase(){
        ex150 = new Ex150();
    }

    @Test
    public void testEvalRPN(){
        String[] test1 = new String[]{
              "2","1","+","3","*"
        };
        String[] test2 = new String[]{
              "4","13","5","/","+"
        };
        String[] test3 = new String[]{
              "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        };
        Assert.assertEquals(ex150.evalRPN(test1),9);
        Assert.assertEquals(ex150.evalRPN(test2),6);
        Assert.assertEquals(ex150.evalRPN(test3),22);


    }
}
