package leetCode;

public class Ex968 {
    public int minCameraCover(TreeNode root) {
        return helper(root)[1];
    }


    private int[] helper(TreeNode root){
        if(root==null){
            return new int[]{Integer.MAX_VALUE/2,0,0};
        }
        var l = helper(root.left);
        var r = helper(root.right);
        var temp = new int[3];
        temp[0] = l[2]+r[2]+1;
        temp[1] = Math.min(temp[0], Math.min(l[1]+r[0], l[0]+r[1]));
        temp[2] = Math.min(temp[0], l[1]+r[1]);
        return temp;
    }
}
