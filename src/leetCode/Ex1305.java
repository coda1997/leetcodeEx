package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        List<Integer> res = new ArrayList<>(l1.size()+l2.size());
        int i = 0,j = 0;
        int M = l1.size();
        int N = l2.size();
        while (i<M&&j<N){
            int i1 = l1.get(i);
            int i2 = l2.get(j);
            if (i1<i2){
                res.add(i1);
                i++;
            }else{
                res.add(i2);
                j++;
            }
        }
        while (i<M){
            res.add(l1.get(i++));
        }
        while (j<N){
            res.add(l2.get(j++));
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }
}
