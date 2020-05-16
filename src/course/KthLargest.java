package course;

import java.util.TreeSet;

public class KthLargest {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int count = 1;
        public TreeNode(int val){
            this.val = val;
        }
    }
    private TreeNode root;
    private int rank;

    private void insertNode(TreeNode root, int val){
        if(root==null){
            root = new TreeNode(val);
            this.root = root;
            return;
        }

        //root must not be null
        if(root.val>val){
            if(root.left==null){
                root.left = new TreeNode(val);
                root.count++;
                return;
            }else{
                insertNode(root.left, val);
                root.count++;
            }
        }else if(root.val<=val){
            if(root.right==null){
                root.right = new TreeNode(val);
                root.count++;
                return;
            }else{
                insertNode(root.right, val);
                root.count++;
            }
        }
    }

    public KthLargest(int k, int[] nums) {
        this.rank = k;
        for(int i = 0; i<nums.length;i++){
            insertNode(root, nums[i]);
        }
    }
    private int findK(TreeNode root, int k){
        int count = 0;
        if(root.right!=null){
            count = root.right.count;
        }
        if(count<k){
            if(count+1==k){
                return root.val;
            }else{
                return findK(root.left, k-count-1);
            }
        }else{
            return findK(root.right, k);
        }
    }
    
    public int add(int val) {
        insertNode(root, val);
        var res = findK(root, rank);
        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        var min = p.val<q.val? p.val:q.val;
        var max = p.val>q.val? p.val:q.val;

        return recursiveAncestor(root, min, max);
    }
    private TreeNode recursiveAncestor(TreeNode root, int min, int max){
        if(root==null){
            return null;
        }
        if(root.val>max){
            return recursiveAncestor(root.left, min, max);
        }else if(root.val<min){
            return recursiveAncestor(root.right, min, max);
        }
        //then root.val >=min, <=max
        return root;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        var set = new TreeSet<Integer>();
        for(int i = 0; i<nums.length;i++){
            var larger = set.ceiling(nums[i]);
            if(larger!=null&& larger<= nums[i]+t){
                return true;
            }
            var smaller = set.floor(nums[i]);
            if(smaller!=null&& nums[i]<= smaller+t){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var kthLargest = new KthLargest(1, new int[]{});
        kthLargest.add(-3);   // returns 4
        kthLargest.add(-2);   // returns 5
        kthLargest.add(-4);  // returns 5
        kthLargest.add(0);   // returns 8
        kthLargest.add(4);   // returns 8
    }
}