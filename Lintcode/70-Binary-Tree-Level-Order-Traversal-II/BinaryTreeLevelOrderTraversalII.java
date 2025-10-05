import java.util.ArrayList;
import java.util.Collections;

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */
public class BinaryTreeLevelOrderTraversalII {
	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: buttom-up level order a list of lists of integer
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		ArrayList<TreeNode> currLevel = new ArrayList<>();
		currLevel.add(root);
		ArrayList<TreeNode> nextLevel = new ArrayList<>();
		ArrayList<Integer> level;
		while (!currLevel.isEmpty()) {
			level = new ArrayList<>();
			for (int i = 0; i < currLevel.size(); i++) {
				TreeNode node = currLevel.get(i);
				level.add(node.val);
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			res.add(level);
			currLevel = nextLevel;
			nextLevel = new ArrayList<>();
		}
		Collections.reverse(res);
		return res;
	}
}
