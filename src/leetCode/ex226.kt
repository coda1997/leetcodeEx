package leetCode



class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root != null){
            val temp = invertTree(root.left)
            root.left= invertTree(root.right)
            root.right=temp
        }
        return root
    }
//
//    private fun reverseTree(root: TreeNode){
//
//        if(root.left==null){
//
//        }
//    }
}

fun main(args: Array<String>) {
    val root = TreeNode()
    val l = TreeNode(112)
    val r = TreeNode(12)
    root.left=l
    l.right=r
    Solution().invertTree(root).apply { println(root.right?.left?.`val`) }
}