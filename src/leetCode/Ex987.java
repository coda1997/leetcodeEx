package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0,0);
        res.sort((o1, o2) ->{
            if (o1[0]==o2[0]){
                if (o1[1]==o2[1]){
                    return o1[2]-o2[2];
                }else{
                    return o1[1]-o2[1];
                }
            }else{
                return o1[0]-o2[0];
            }
        });
        var ret = new ArrayList<List<Integer>>();

        return ret;
    }
    private List<int[]> res;
    private void dfs(TreeNode root, int row, int col){
        if(root==null){
            return;
        }
        res.add(new int[]{col, row, root.val});
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
}
