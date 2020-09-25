package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex501 {
    int base, count, maxCount;
    List<Integer> res = new ArrayList<>();
    

    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;

        while(cur!=null){
            if(cur.left==null){
                updateNum(cur.val);
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right!=null&&pre.right!=cur){
                    pre = pre.right;
                }
                //two cases. 1st, pre.right is null, then we get the pre of the cur
                //2nd, pre.right is cur, which means we have traversal to the cur after cur.left
                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    updateNum(cur.val);
                    cur = cur.right;
                }

            }
        }
        int[] ress = new int[res.size()];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = res.get(i);
        }

        return ress;
    }


    private void updateNum(int val){
        if(val == base){
            count++;
        }else{
            base = val;
            count=1;
        }
        if(count == maxCount){
            res.add(val);
        }
        if(count > maxCount){
            maxCount = count;
            res.clear();
            res.add(val);
        }
    }
}
