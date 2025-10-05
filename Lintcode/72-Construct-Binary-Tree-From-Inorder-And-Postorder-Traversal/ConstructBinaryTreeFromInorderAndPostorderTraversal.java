
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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	/**
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @param postorder
	 *            : A list of integers that postorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		return build(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	private TreeNode build(int[] inorder, int inleft, int inright,
			int[] postorder, int postleft, int postright) {
		if (postleft > postright) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postright]);
		if (postright == postleft) {
			return root;
		}
		int index = search(inorder, inleft, inright, postorder[postright]);
		int leftLen = index - inleft;
		int rightLen = inright - index;
		root.left = build(inorder, inleft, index - 1, postorder, postleft,
				postleft + leftLen - 1);
		root.right = build(inorder, index + 1, inright, postorder, postright
				- rightLen, postright - 1);
		return root;
	}

	private int search(int[] arr, int start, int end, int target) {
		for (int i = start; i <= end; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
