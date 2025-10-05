import java.util.ArrayList;
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
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> temp;
        currLevel.push(root);
        boolean isNormalOrder = true;
        while (!currLevel.empty()) {
            ArrayList<Integer> level = new ArrayList<>();
            while (!currLevel.empty()) {
                TreeNode cur = currLevel.pop();
                if (cur == null) {
                    continue;
                }
                level.add(cur.val);
                if (isNormalOrder) {
                    nextLevel.push(cur.left);
                    nextLevel.push(cur.right);
                } else {
                    nextLevel.push(cur.right);
                    nextLevel.push(cur.left);
                }
            }
            isNormalOrder = !isNormalOrder;
            if (level.size()>0) {
                res.add(level);
            }
            temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;
        }
        return res;
    }
}
