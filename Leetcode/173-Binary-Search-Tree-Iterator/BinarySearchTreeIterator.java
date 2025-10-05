import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinarySearchTreeIterator {

    private Stack<TreeNode> mStack;

    public BinarySearchTreeIterator(TreeNode root) {
        mStack = new Stack<>();
        while (root!=null) {
            mStack.push(root);
            root = root.left; 
        }
    }
    /*
    public BSTIterator(TreeNode root) {
        mStack = new Stack<>();
        if (root != null) {
            mStack.push(root);
        }
        
        while (!mStack.empty() && mStack.peek().left!=null) {
            mStack.push(mStack.peek().left);
        }
    }*/

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mStack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = mStack.pop();
        int res = node.val;
        if (node.right!=null) {
            node = node.right;
            while (node!=null) {
                mStack.push(node);
                node = node.left;
            }
        }
        return res;
    }
    /*
    public int next() {
        TreeNode node = mStack.pop();
        int res = node.val;
        if (node.right != null) {
            mStack.push(node.right);
        }
        
        while (!mStack.empty() && mStack.peek().left!=null) {
            mStack.push(mStack.peek().left);
        }
        return res;
    }*/
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */