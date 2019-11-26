package leetCode

import java.util.*
import kotlin.collections.HashSet

fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val stack = Stack<TreeNode>()
    if (root==null){
        return res
    }
    val tempPath = mutableListOf<Int>()
    stack.push(root)
    val usedSet = HashSet<TreeNode>()
    while (stack.isNotEmpty()){
        val t = stack.peek()
        if (usedSet.contains(t)){
            tempPath.removeAt(tempPath.size-1)
            stack.pop()
            continue
        }
        usedSet.add(t)
        tempPath.add(t.`val`)
        if (t.right!=null){
            stack.push(t.right)
        }
        if (t.left!=null){
            stack.push(t.left)
        }
        if (t.left==null&&t.right==null){
            //t is leave node
            if (tempPath.sum()==sum) {
                val cp = mutableListOf<Int>().apply {
                    tempPath.forEach { this.add(it) }
                }
                res.add(cp)
            }
        }
    }
    return res
}


