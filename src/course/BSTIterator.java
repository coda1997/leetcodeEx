package course;

import leetCode.TreeNode;

class BSTIterator {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        TreeNode parent = null;
        TreeNode t = root;
        while(t!=null){
            if(t.val < key){
                parent = t;
                t = t.right;
            }else if(t.val > key){
                parent = t;
                t = t.left;
            }else{
                if(t.left!=null&&t.right!=null){
                    deleteNodeWithTwo(parent, t);
                    break;
                }
                if(t.left!=null){
                    if(parent==null){
                        root = t.left;
                        break;
                    }else{
                        deleteNodeWithOne(parent,t,t.left);
                        break;
                    }
                    
                }
                if(t.right!=null){
                    if(parent==null){
                        root = t.right;
                        break;
                    }else{
                        deleteNodeWithOne(parent,t,t.right);
                        break;
                    }
                }
                if(parent == null){
                    return null;
                }
                de(parent, t);
                break;
            }
        }
        return root;
        
    }
    private void de(TreeNode parent, TreeNode d){
        if(parent.left==d){
            parent.left = null;
        }else if(parent.right==d){
            parent.right = null;
        }
    }
    private void deleteNodeWithOne(TreeNode parent, TreeNode d, TreeNode s){
        if(parent.left==d){
            parent.left = s;
        }else if(parent.right==d){
            parent.right = s;
        }
    }
    private void deleteNodeWithTwo(TreeNode parent, TreeNode d){
        TreeNode suc = findSuc(d.right);
        int temp = suc.val;
        suc.val = d.val;
        d.val = temp;
        d.right = deleteNode(d.right,suc.val);
    }
    
    private TreeNode findSuc(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode t = root;
        while(t.left!=null){
            t = t.left;
        }
        return t;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        var t = new BSTIterator().deleteNode(root, 3);
        System.out.println(t.val);
    }
}

