package leetCode;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Ex117 {
    public Node connect(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        Node dummy = new Node(0);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(dummy);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == dummy) {
                if(queue.isEmpty()){
                    break;
                }
                queue.add(dummy);
                continue;
            }
            if (queue.peek() == dummy) {
                temp.next = null;
            } else {
                temp.next = queue.peek();
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root = new Ex117().connect(root);

    }
}

