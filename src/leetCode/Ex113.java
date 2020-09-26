package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex113 {
    private List<Integer> temps = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, 0);
        return res;
    }

    private void helper(TreeNode root, int sum, int temp){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null&&temp+root.val==sum){
            temps.add(root.val);
            res.add(new ArrayList<>(temps));
            temps.remove(temps.size()-1);
            return;
        }
        temps.add(root.val);
        helper(root.left, sum, temp+root.val);
        helper(root.right, sum, temp+root.val);
        temps.remove(temps.size()-1);
    }
}