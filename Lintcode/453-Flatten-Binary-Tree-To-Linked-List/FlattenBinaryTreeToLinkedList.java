
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


public class FlattenBinaryTreeToLinkedList {
	/**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        getList(root);
    }
    private Result getList(TreeNode node) {
        Result res = new Result(node, node);
        Result left = null;
        if (node.left != null) {
            left = getList(node.left);
        }
        Result right = null;
        if (node.right != null) {
            right = getList(node.right);
        }
        // merge
        node.left = null;
        if (left != null) {
            res.tail.right = left.head;
            res.tail = left.tail;
        }
        if (right != null) {
            res.tail.right = right.head;
            res.tail = right.tail;
        }
        return res;
    }
    private static class Result {
        public TreeNode head;
        public TreeNode tail;
        public Result(TreeNode h, TreeNode t) {
            head = h;
            tail = t;
        }
    }
}
