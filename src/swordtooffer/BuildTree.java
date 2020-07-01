package swordtooffer;

import leetCode.TreeNode;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTree(preorder, inorder,0,preorder.length,0,inorder.length);

    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int i, int j, int m, int n){
        if(j-i==0){
            return null;
        }
        var root = new TreeNode(preorder[i]);
        if(j-i==1){
            return root;
        }
        var t = -1;
        for (int k = m; k < n; k++) {
            if(inorder[k]==preorder[i]){
                t = k;
                break;
            }
        }
        // it is the length of left sub-tree;
        var len = t-m;
        root.left = buildTree(preorder, inorder, i+1, len+i+1,m,m+len );
        root.right = buildTree(preorder, inorder, len+i+1,j,t+1,n);
        return root;
    }

    
}