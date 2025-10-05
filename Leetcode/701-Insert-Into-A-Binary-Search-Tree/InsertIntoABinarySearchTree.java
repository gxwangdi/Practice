/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
            return root;
        }
        TreeNode cur = root;
        while(true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
                continue;
            }
            if (cur.right == null) {
                cur.right = node;
                break;
            }
            cur = cur.right;
        }
        return root;
    }

    // Recursive approach
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         TreeNode node = new TreeNode(val);
//         return insert(root, node);
//     }

//     private TreeNode insert(TreeNode root, TreeNode node) {
//         if (root== null) {
//             root = node;
//             return root;
//         }
//         if (root.val > node.val) {
//             root.left = insert(root.left, node);
//         } else {
//             root.right = insert(root.right, node);
//         }
//         return root;
//     }
}
