package review;

import leetCode.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        //pre-order traversal
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            sb.append("]");
            return sb.toString();
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            var item = stack.pop();
            if (item == null) {
                sb.append("null,");
            }else{
                sb.append(item.val).append(',');
                stack.push(item.right);
                stack.push(item.left);
            }
        }
        sb.deleteCharAt(sb.length()-1).append(']');
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //check whether the data is valid
        if (data == null || data.length() <= 2) {
            return null;
        }
        //convert data to tokens
        String[] tokens = data.substring(1, data.length()-1).split(",");
        LinkedList<String> ts = new LinkedList<>();
        for (String token :
                tokens) {
            ts.addLast(token);
        }
        return helper(ts);
    }

    private TreeNode helper(LinkedList<String> tokens) {
        if (tokens.isEmpty()||tokens.getFirst().equals("null")){
            tokens.removeFirst();
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(tokens.get(0)));
        tokens.removeFirst();
        cur.left = helper(tokens);
        cur.right = helper(tokens);
        return cur;
    }

    public static void main(String[] args) {
        var o = new Codec();
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = o.serialize(root);
        System.out.println(serialize);
        o.deserialize(serialize);
    }
}
