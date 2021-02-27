package leetCode;

public class Ex421 {
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int mask = 1<<30;
        for (int num : nums) {
            add(root, num, mask);
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, findXoR(root, num, mask)^num);
        }
        return res;
    }

    class Node{
        Node left = null;
        Node right = null;
        boolean isEnd = false;
        int num = 0;
    }

    private int findXoR(Node root, int item, int mask){
        if (root.left==null&&root.right==null){
            return root.num;
        }
        if (root.right == null) {
            return findXoR(root.left, item, mask>>1);
        }
        if (root.left ==null){
            return findXoR(root.right, item, mask>>1);
        }
        if ((item&mask)==0){
            return findXoR(root.right, item, mask>>1);
        }else{
            return findXoR(root.left, item, mask>>1);
        }
    }

    private void add(Node root, int i, int mask){
        if (mask==0){
            root.isEnd = true;
            root.num = i;
        }else{
            if ((mask&i)==0){
                if (root.left == null) {
                    root.left = new Node();
                }
                add(root.left, i, mask>>1);
            }else{
                if (root.right == null) {
                    root.right = new Node();
                }
                add(root.right, i, mask>>1);
            }
        }
    }

    public static void main(String[] args) {
        var o = new Ex421();
        System.out.println(o.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

}
