import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
public class BinaryTreeSerialization {
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<String> res = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				res.add("#");
			} else {
				res.add(node.val + "");
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		while ("#".equals(res.get(res.size() - 1))) {
			res.remove(res.size() - 1);
		}
		StringBuilder sb = new StringBuilder(res.size() * 2 - 1);
		for (int i = 0; i < res.size(); i++) {
			if (i != 0) {
				sb.append(',');
			}
			sb.append(res.get(i));
		}
		return sb.toString();
	}
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0 || data.startsWith("#")) {
			return null;
		}
		String[] nodes = data.split("[,]");
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
		queue.offer(root);
		int cur = 1;
		while (cur < nodes.length && !queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode temp;
			if (!"#".equals(nodes[cur])) {
				temp = new TreeNode(Integer.valueOf(nodes[cur]));
				queue.offer(temp);
			} else {
				temp = null;
			}
			node.left = temp;
			cur++;
			if (cur >= nodes.length) {
				break;
			}
			if (!"#".equals(nodes[cur])) {
				temp = new TreeNode(Integer.valueOf(nodes[cur]));
				queue.offer(temp);
			} else {
				temp = null;
			}
			node.right = temp;
			cur++;
		}
		return root;
	}
}
