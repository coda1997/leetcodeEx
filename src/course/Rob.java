package course;
import leetCode.TreeNode;
/**
 * Rob
 */
public class Rob {

    public int rob(TreeNode root) {
        var res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        var ls = helper(root.left);
        var rs = helper(root.right);
        var temp = ls[0]+rs[0];
        temp = Math.max(temp, Math.max(ls[0]+rs[1], Math.max(ls[1]+rs[0], ls[1]+rs[1])));
        return new int[]{ls[1]+rs[1]+root.val,temp };

    }
}