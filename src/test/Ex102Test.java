package test;

import leetCode.Ex102;
import leetCode.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class Ex102Test {
    private Ex102 ex102;

    @Before
    public void createTestCase() {
        ex102 = new Ex102();
    }

    @Test
    public void testLevelOrder(){
        TreeNode root = new TreeNode(0);
        ex102.levelOrder(root);
    }


}
