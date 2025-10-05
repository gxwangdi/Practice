
/**
 * Definition of TreeNode: 
 * public class TreeNode { 
 * 		public int val; 
 * 		public TreeNode left, right; 
 * 
 * public TreeNode(int val) { 
 * 		this.val = val; 
 * 		this.left = this.right = null; 
 * } 
 * }
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	/**
	 * @param preorder
	 *            : A list of integers that preorder traversal of a tree
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		return build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int preleft, int preright,
			int[] inorder, int inleft, int inright) {
		if (preleft > preright) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preleft]);
		if (preleft == preright) {
			return root;
		}
		int index = Search(inorder, inleft, inright, preorder[preleft]);
		int leftLen = index - inleft;
		int rightLen = inright - index;
		root.left = build(preorder, preleft + 1, preleft + leftLen, inorder,
				inleft, index - 1);
		root.right = build(preorder, preleft + leftLen + 1, preright, inorder,
				index + 1, inright);
		return root;
	}

	private int Search(int[] arr, int start, int end, int target) {
		for (int i = start; i <= end; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
