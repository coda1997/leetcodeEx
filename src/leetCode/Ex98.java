package leetCode;

public class Ex98 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;


    }
    private TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean f = isValidBST(root.left);
        boolean f2 = pre==null||pre.val<root.val;
        pre = root;
        return f&&f2&&isValidBST(root.right);


    }

}
