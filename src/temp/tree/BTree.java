package temp.tree;

public class BTree {
    private BTreeNode root;
    private int degree; //this is minimum degree
    BTree(int t){
        root = null;
        degree = t;
    }

    public void traverse(){
        if (this.root != null) {
            root.traverse();
        }
        System.out.println();
    }

    public BTreeNode search(int k) {
        if (this.root == null) {
            return null;
        }
        return root.search(k);
    }

    class BTreeNode{
        int[] keys;
        int m;
        BTreeNode[] children;
        int n;//current number of keys or a pointer to the first unused index of keys
        boolean isLeaf;

        BTreeNode(int m, boolean isLeaf) {
            this.m = m;
            keys = new int[2*m-1];
            children = new BTreeNode[2*m];
            n =0;
            this.isLeaf = isLeaf;
        }


        void traverse(){
            int i = 0;
            while(i<n){
                if (!isLeaf) {
                    children[i].traverse();
                }
                //do some operations for keys[i]
                i++;
            }
            //note do not forget the last one;
            if (!isLeaf) {
                children[i].traverse();
            }
        }

        BTreeNode search(int k) {
            int i = 0;
            while (i < n && k > keys[i]) {
                i++;
            }
            if (k == keys[i]) {
                return this;
            }
            //if this node is a leaf, it means there is no key equals to k.
            if (isLeaf) {
                return null;
            }
            return children[i].search(k);
        }
    }


}
