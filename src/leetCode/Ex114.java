package leetCode;

public class Ex114 {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root){
        if(root==null){
            return null;
        }
        var left = root.left;
        var right = root.right;

        var pre = helper(left);
        var preRight = helper(right);
        if(pre !=null){
            pre.right = right;
            root.right = left;
            root.left = null;
        }
        if(preRight==null){
            if(pre==null){
                return root;
            }else{
                return pre;
            }
        }
        return preRight;
    }
}