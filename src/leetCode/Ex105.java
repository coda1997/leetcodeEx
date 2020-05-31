package leetCode;

public class Ex105 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,inorder.length);
    }
    private TreeNode buildTree(int[] preorder,int[] inorder,int start,int end){
        if (start>=end){
            return null;
        }
        for(int j=start;j<end;j++){
            if (inorder[j]==preorder[ii]){
                TreeNode root = new TreeNode(preorder[ii--]);
                root.right=buildTree(preorder,inorder,j+1,end);
                root.left=buildTree(preorder,inorder,start,j);
                return root;
            }
        }
        return null;
    }
    private int ii;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ii=postorder.length-1;
        return buildTree(postorder, inorder, 0, inorder.length);
    }
}
