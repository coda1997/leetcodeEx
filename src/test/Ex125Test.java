package test;

import leetCode.Ex125;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class Ex125Test {

    private Ex125 ex125;

    @Before
    public void createTestCase() {
        ex125 = new Ex125();
    }

    @Test
    public void testIsPalindrome(){
        String t1 = "A man, a plan, a canal: Panama";//true case
        String t2 = "race a car";//false case

        assertTrue(ex125.isPalindrome(t1));
        assertFalse(ex125.isPalindrome(t2));
    }
}
