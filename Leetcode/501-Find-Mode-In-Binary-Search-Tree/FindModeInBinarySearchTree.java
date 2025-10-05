
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindModeInBinarySearchTree {
  private int maxCount;
	private int currentCount;
	private int lastValue = Integer.MIN_VALUE;

	private List<Integer> modeList = new ArrayList<>();

	public int[] findMode(TreeNode root) {
		inOrderTraversal(root);
        int[] modes = modeList.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
		// int[] modes = new int[modeList.size()];
		// int idx = 0;
		// for (int mode : modeList) {
		// 	modes[idx++] = mode;
		// }
		return modes;
	}

	private void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		addMode(root);
		inOrderTraversal(root.right);
	}

	private void addMode(TreeNode node) {
		if (lastValue != node.val) {
			currentCount = 0;
			lastValue = node.val;
		}
		currentCount++;
		if (currentCount > maxCount) {
			maxCount = currentCount;
			modeList.clear();
			modeList.add(node.val);
		} else if (currentCount == maxCount) {
			modeList.add(node.val);
		}
	}
}
