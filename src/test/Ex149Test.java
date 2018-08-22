package test;

import leetCode.Ex149;
import leetCode.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Ex149Test {

    private Ex149 ex149;

    @Before
    public void createTestCase(){
        ex149 = new Ex149();
    }

    @Test
    public void test(){
        Point[] points = new Point[3];
        points[0] = new Point(1,1);
        points[1] = new Point(2,2);
        points[2] = new Point(3,3);

        Assert.assertEquals(ex149.maxPoints(points),3);
    }
}
