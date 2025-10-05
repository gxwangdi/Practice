
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class SameTree {
    // Recursive manner       
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        }
        
        if ((p==null && q!=null) || (p!=null && q==null)) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }// end of isSameTree 
    
    // Iterative build in-order/post-order.
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p==null && q==null) {
    //         return true;
    //     }
        
    //     if ((p==null && q!=null) || (p!=null && q==null)) {
    //         return false;
    //     }
        
    // }// end of isSameTree 
}