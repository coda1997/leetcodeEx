package leetCode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return if (p!=null&&q!=null){
        p.`val`==q.`val`&& isSameTree(p.left,q.left)&& isSameTree(p.right,q.right)
    }else{
        p==null&&q==null
    }
}