package leetCode

import java.util.*

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val stack1 = Stack<TreeNode>()
    val stack2 = Stack<TreeNode>()
    stack1.push(root1)
    stack2.push(root2)
    while (stack1.isNotEmpty()&&stack2.isNotEmpty()){
        var t1 = stack1.pop()
        var t2 = stack2.pop()
        while (!isLeaf(t1)){
            if (t1.right != null) {
                stack1.push(t1.right)
            }
            if (t1.left != null) {
                stack1.push(t1.left)
            }
            t1 = stack1.pop()
        }
        while (!isLeaf(t2)){
            if (t2.right != null) {
                stack2.push(t2.right)
            }
            if (t2.left != null) {
                stack2.push(t2.left)
            }
            t2=stack2.pop()
        }
        if (t1.`val` != t2.`val`) {
            return false
        }
    }
    if (stack1.isNotEmpty()||stack2.isNotEmpty()){
        return false
    }
    return true
}

fun isLeaf(root:TreeNode):Boolean{
    return root.left==null&&root.right==null
}