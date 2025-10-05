
public class BSTSwappedNodes {
	/*
     * @param : the given tree
     * @return: the tree after swapping
     */
    public TreeNode bstSwappedNode(TreeNode root) {
        if(root==null) {
            return root;
        }
        inorder(root);
        if(second!=null && first !=null){
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }
        return root;
    }
    
    private TreeNode first;
    private TreeNode second; 
    private TreeNode pre; 
    
    private void inorder(TreeNode root){
        if(root==null) {
        	    return;
        }
        inorder(root.left);
        if(pre==null){
            pre=root;
        }else{
            if(root.val<pre.val){
                if(first==null){
                    first=pre;
                }
                second=root;
            }
            pre=root;
        }
        inorder(root.right);
    }// end of inorder.
}




