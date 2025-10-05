import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root!= null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append(",#");
                continue;
            }
            if (sb.length() !=0) {
                sb.append(',');
            }
            sb.append(node.val);
            q.offer(node.left);
            q.offer(node.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() ==0) {
            return null;
        }
        String[] tokens = data.split("[,]");
        int cur = 0;
        if ("#".equals(tokens[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(tokens[cur++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (cur < tokens.length) {
            TreeNode node = q.poll();
            String left = tokens[cur++];
            if (!"#".equals(left)) {
                node.left = new TreeNode(Integer.valueOf(left));
                q.offer(node.left);
            }
            if (cur >= tokens.length) {
                break;
            }
            String right = tokens[cur++];
            if (!"#".equals(right)) {
                node.right = new TreeNode(Integer.valueOf(right));
                q.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



