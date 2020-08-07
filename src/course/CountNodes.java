package course;

import leetCode.TreeNode;

/**
 * CountNodes
 * 给出一个完全二叉树，求出该树的节点个数。
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        var temp = root;
        int l = 0;
        while(temp.left!=null){
            temp = temp.left;
            l++;
        }
        int res = 0;
        for (int i = 0; i < l; i++) {
            res += (int)Math.pow(2, i);
        }
        int height = (int)Math.pow(2, l);
        int r = height;
        l = 0;
        while(l<r){
            int mid = (l+r)/2;
            if(isNode(root, mid, height)){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        res += l;

        return res;
    }
    private boolean isNode(TreeNode root, int i, int nodes){
        for (int j = nodes/2; j>0; j/=2) {
            if((j&i)==0){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root != null;
    }
    
}