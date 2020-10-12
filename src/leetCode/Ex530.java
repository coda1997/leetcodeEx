package leetCode;

public class Ex530 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        TreeNode succ, cur;
        cur = root;
        succ = null;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.left==null){
                if(pre!=null){
                    min = Math.min(min,cur.val-pre.val);
                }
                pre = cur;
                cur = cur.right;
            }else{
                succ = cur.left;
                while(succ.right!=null&&succ.right!=cur){
                    succ = succ.right;
                }
                if(succ.right==null){
                    succ.right = cur;
                    cur = cur.left;
                }else{
                    succ.right = null;
                    if(pre!=null){
                        min = Math.min(min,cur.val-pre.val);
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }

        return min;
    }
}
