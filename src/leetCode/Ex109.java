package leetCode;
/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 */
public class Ex109 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }


    private TreeNode helper(ListNode l, ListNode r){
        if(l==r){
            return null;
        }
        ListNode fast = l, slow = l;
        while(fast!=r&&fast.next!=r){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        //here slow is the middle point.
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(l, slow);
        root.right = helper(slow.next, r);
        return root;
    }
}