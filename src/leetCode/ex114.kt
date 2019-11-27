package leetCode

import java.util.*
import kotlin.collections.HashSet

fun flatten(root: TreeNode?): Unit {
    if (root==null){
        return
    }
    var head :TreeNode?= null
    val stack = Stack<TreeNode>()
    val set = HashSet<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()){
        val t = stack.peek()
        if (set.contains(t)){
            stack.pop()
            t.left=null
            t.right=head
            head = t
        }else{
            set.add(t)
            if (t.left!=null){
                stack.push(t.left)
            }
            if (t.right!=null){
                stack.push(t.right)
            }
        }
    }
}