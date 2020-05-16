package leetCode

import java.util.*

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}


fun connect(root: Node?): Node? {
    val queue :Queue<Node> = LinkedList<Node>()
    if (root == null){
        return root
    }
    queue.add(root)
    var base = 1
    var t = 0
    while (queue.isNotEmpty()){
        val temp = queue.poll()
        t++
        if (queue.isNotEmpty()){
            temp.next = queue.peek()
        }
        if (temp.left!=null){
            queue.add(temp.left)
        }
        if (temp.right != null) {
            queue.add(temp.right)
        }
        if (t==base){
            temp.next = null //it is the lastest one in the same level
            base *= 2
            t=0
        }
    }
    return root
}

fun main() {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left?.apply {
        left = Node(4)
        right = Node(5)
    }
    root.right?.apply {
        left = Node(6)
        right = Node(7)
    }
    connect(root)
}