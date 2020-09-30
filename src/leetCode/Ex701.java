package leetCode;

public class Ex701{
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        var temp = root;
        TreeNode pre = null;
        while(temp!=null){
            pre = temp;
            if(temp.val>val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        if(pre == null){
            return new TreeNode(val);
        }
        if(pre.val>val){
            pre.left = new TreeNode(val);
        }else{
            pre.right = new TreeNode(val);
        }


        return root;
    }
}