package leetCode;

public class Ex108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){
            return null;
        }
        TreeNode root = new TreeNode();
        if (nums.length==1){
            root.val=nums[0];
        }else {
            int mid = nums.length / 2;
            root.val = nums[mid];
            root.left= sortedArrayToBSTInOneLevel(nums,0,mid);
            root.right = sortedArrayToBSTInOneLevel(nums,mid+1,nums.length);
        }

        return root;
    }

    private TreeNode sortedArrayToBSTInOneLevel(int[] nums,int start,int end){
        if (start>=end){
            return null;
        }

        int mid = (end-start)/2+start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTInOneLevel(nums,start,mid);
        root.right=sortedArrayToBSTInOneLevel(nums,mid+1,end);
        return root;
    }

}
