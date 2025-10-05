
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class HouseRobberIII {
	/**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
	public int houseRobber3(TreeNode root) {
		int[] max = dfs(root);

		return Math.max(max[0], max[1]);
	}

	private int[] dfs(TreeNode root) {
		int[] max = new int[2];
		if (root == null) {
			return max;
		}

		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		max[1] = left[0] + right[0] + root.val;
		return max;
	}
}
