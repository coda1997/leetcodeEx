package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex95 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> trees = new ArrayList<>();
        for (int i = 0;i<n;i++){
            dfs(i+1,n,trees,new TreeNode(i+1));
        }
        return trees;
    }
    private void dfs(int k,int num,ArrayList<TreeNode> res,TreeNode header){
        
//
    }
    private int i = 0;
    private int f(int n ){
        i++;
        if (n<=3) return 1;
        else return f(n-2)+f(n-6)+1;
    }

    public static void main(String[] args) {
        Ex95 t = new Ex95();
        System.out.println(t.f(t.f(9)));
        System.out.println(t.i);
    }
}
