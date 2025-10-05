/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (getHeight(root)==-1) {
            return false;
        }
        return true;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) 
            return 0;
        
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (left == -1 || right == -1)
            return -1;
        
        if (Math.abs(left-right)>1)
            return -1;
        
        return Math.max(left, right) + 1;
    }
    
    /*
    public boolean isBalanced(TreeNode root) {
        if (root == null) 
            return true;
        
        boolean isEnd = false; 
        int cur = 0;
        Deque<TreeNode>[] q = new Deque[2];
        q[0] = new ArrayDeque<>();
        q[1] = new ArrayDeque<>();
        q[0].add(root);
        int curIte = 0;
        int nextIte = 0;
        while (!isEnd) {
            curIte = cur%2;
            nextIte = 1-curIte;
            
            while (q[curIte].size()>0) {
                TreeNode temp = q[curIte].poll();
            if (temp.left == null) {
                isEnd = true;
            } else {
                q[nextIte].add(temp.left);
            }
            if (temp.right == null) {
                isEnd = true;
            } else {
                q[nextIte].add(temp.right);
            }
            }// end of while q[curIte]
        }
        if (q[nextIte].size() == 0) {
            return true;
        }
        while (q[nextIte].size() > 0) {
            TreeNode temp = q[nextIte].poll();
            if (temp.left!=null || temp.right!=null)
                return false;
        }
        return true;
    }*/
}