import java.util.ArrayList;
import java.util.List;

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */
public class BinaryTreePathSumII {
	/**
	 * @param root
	 *            the root of binary tree
	 * @param target
	 *            an integer
	 * @return all valid paths
	 */
	// There are duplicate checks for this case.
	// public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target)
	// {
	// List<List<Integer>> result = new ArrayList<>();
	// if (root == null) {
	// return result;
	// }
	// getPath(result, new ArrayList<Integer>(), root, 0, target);
	// return result;
	// }
	// private void getPath(
	// List<List<Integer>> result,
	// List<Integer> prog,
	// TreeNode root,
	// int sum,
	// int target) {
	// sum += root.val;
	// prog.add(root.val);
	// if (sum == target && !result.contains(prog)) {
	// result.add(prog);
	// }
	// if (root.left != null) {
	// getPath(result, new ArrayList<Integer>(prog), root.left,
	// sum, target);
	// getPath(result, new ArrayList<Integer>(),
	// root.left, 0, target);
	// }
	// if (root.right != null) {
	// getPath(result, new ArrayList<Integer>(prog), root.right,
	// sum, target);
	// getPath(result, new ArrayList<Integer>(),
	// root.right, 0, target);
	// }
	// }
	/**
	 * @param root
	 *            the root of binary tree
	 * @param target
	 *            an integer
	 * @return all valid paths
	 */
	public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		List<Integer> list = new ArrayList<>();
		helper(root, result, list, target);
		return result;
	}

	public void helper(TreeNode root, List<List<Integer>> result,
			List<Integer> list, int target) {
		if (root == null) {
			return;
		}

		list.add(root.val);
		int sum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			sum += list.get(i);
			if (sum == target) {
				List<Integer> res = new ArrayList<>();
				for (int j = i; j < list.size(); j++) {
					res.add(list.get(j));
				}
				result.add(res);
			}
		}
		helper(root.left, result, list, target);
		helper(root.right, result, list, target);
		// backtrace.
		list.remove(list.size() - 1);
	}
}
