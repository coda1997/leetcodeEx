package leetCode;


public class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next=null;
    }



    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +"}";
    }

    public ListNode() {
        this(0);
    }
}
