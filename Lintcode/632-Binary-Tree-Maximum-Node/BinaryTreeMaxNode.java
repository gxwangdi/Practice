import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxNode {
	public TreeNode maxNode(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		TreeNode max = root;
		while (q.peek() != null) {
			TreeNode temp = q.poll();
			if (temp.val > max.val) {
				max = temp;
			}
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
		return max;
	}
}
