package leetCode

fun sumOfLeftLeaves(root: TreeNode?): Int {

    return dfsTreeLeft(root,false)

}

fun dfsTreeLeft(root: TreeNode?, isLeft:Boolean):Int{
    if (root==null){
        return 0
    }
    if (root.left==null&&root.right==null){
        return if (isLeft){
            root.`val`
        }else{
            0
        }
    }
    return dfsTreeLeft(root.left,true)+ dfsTreeLeft(root.right,false)
}