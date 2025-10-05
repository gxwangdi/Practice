import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> resLevel;
        
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> temp;
        currLevel.push(root);
        
        boolean leftToRight = true;
        
        while (!currLevel.empty()) {
            resLevel = new ArrayList<>();
            
            while (!currLevel.empty()) {
                TreeNode node = currLevel.pop();
                resLevel.add(node.val);
                if (leftToRight) {
                    if (node.left!= null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right!= null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right!=null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left!=null) {
                        nextLevel.push(node.left);
                    }
                }
            }
            temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;
            res.add(resLevel);
            leftToRight = !leftToRight;
        }
        return res;
    }
}




