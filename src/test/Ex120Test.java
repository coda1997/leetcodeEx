package test;

import leetCode.Ex120;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Ex120Test {

    private Ex120 ex120;
    @Before
    public void createTestCase(){
        ex120 = new Ex120();
    }

    @Test
    public void testMinimumTotal(){
        List<List<Integer>> test1 = new ArrayList<List<Integer>>();
        List<Integer> t1= new ArrayList<>();
        t1.add(2);
        test1.add(t1);
        List<Integer> t2 = new ArrayList<>();
        t2.add(3);
        t2.add(4);
        test1.add(t2);
        List<Integer> t3 = new ArrayList<>();
        t3.add(6);
        t3.add(5);
        t3.add(7);
        test1.add(t3);
        List<Integer> t4 = new ArrayList<>();
        t4.add(4);
        t4.add(1);
        t4.add(8);
        t4.add(3);
        test1.add(t4);

        Assert.assertEquals(ex120.minimumTotal(test1),11);




    }
}
