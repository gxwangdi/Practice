import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulatingNextRightPointersInEachNode {

	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> currLevel = new LinkedList<>();
		Queue<TreeLinkNode> nextLevel = new LinkedList<>();
		Queue<TreeLinkNode> temp;

		if (root != null) {
			currLevel.offer(root);
		}

		while (!currLevel.isEmpty()) {
			TreeLinkNode first = null;
			TreeLinkNode last = null;
			while (!currLevel.isEmpty()) {
				first = last;
				last = currLevel.poll();
				if (first != null) {
					first.next = last;
				}
				if (last.left != null) {
					nextLevel.offer(last.left);
				}
				if (last.right != null) {
					nextLevel.offer(last.right);
				}
			}
			temp = nextLevel;
			nextLevel = currLevel;
			currLevel = temp;
		}
	}

	/*
	 * public void connect(TreeLinkNode root) {
	 * 
	 * link(root, root); }
	 * 
	 * public void link(TreeLinkNode left, TreeLinkNode right) { if (left ==
	 * null || right == null) { return; } if (left == right) { link(left.left,
	 * right.right); } else { left.next = right; link(left.right, right.left);
	 * link(left, left); link(right, right); } }
	 */

}
