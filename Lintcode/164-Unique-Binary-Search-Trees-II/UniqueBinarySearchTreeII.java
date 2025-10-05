import java.util.ArrayList;
import java.util.List;

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
public class UniqueBinarySearchTreeII {
	/**
     * @paramn n: An integer
     * @return: A list of root
     */
	public List<TreeNode> generateTrees(int n) {
		if (n < 1) {
			List<TreeNode> res = new ArrayList<>();
			res.add(null);
			return res;
		}
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int left, int right) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (left > right) {
			res.add(null);
			return res;
		}
		if (left == right) {
			TreeNode node = new TreeNode(left);
			res.add(node);
			return res;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> leftNodes = generateTrees(left, i - 1);
			List<TreeNode> rightNodes = generateTrees(i + 1, right);
			for (int j = 0; j < leftNodes.size(); j++) {
				for (int k = 0; k < rightNodes.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftNodes.get(j);
					root.right = rightNodes.get(k);
					res.add(root);
				}
			}
		}
		return res;
	}
}
