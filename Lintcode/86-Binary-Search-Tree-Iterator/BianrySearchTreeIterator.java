import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BianrySearchTreeIterator {

private Stack<TreeNode> mStack;
    
    public BianrySearchTreeIterator(TreeNode root) {
        mStack = new Stack<>();
        while (root != null) {
            mStack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !mStack.empty();
    }
    
    public TreeNode next() {
        TreeNode node = mStack.pop();
        TreeNode tn = node.right;
        while (tn != null) {
            mStack.push(tn);
            tn = tn.left;
        }
        return node;
    }
}
