package leetCode;

public class Ex106 {
    private int[] inorder;
    private int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return helper(0, inorder.length, 0, postorder.length);
    }

    private TreeNode helper(int i, int j, int m, int n){
        if(m==n||i==j){
            return null;
        }

        // m < n
        var root = new TreeNode(postorder[n-1]);
        

        int temp = -1;
        for (int k = i; k < j; k++) {
            if(root.val==inorder[k]){
                temp = k;
                break;
            }
        }
        root.left = helper(i, temp, m, m+temp-i);
        root.right = helper(temp+1, j, n-(j-temp)+1, n);
        return root;
    }
}
