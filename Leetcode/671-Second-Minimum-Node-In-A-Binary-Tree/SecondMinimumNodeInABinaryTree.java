

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
class SecondMinimumNodeInABinaryTree {

    private int min = Integer.MAX_VALUE;
    private boolean flag = false;

    public int findSecondMinimumValue(TreeNode root) {

        if(root == null) {
            return -1;
        }

        if(root.left == null && root.right == null) {
            return -1;
        }
        find(root, root.val);
        return flag ? min : -1;
    }

    private void find(TreeNode root, int minVal) {

        if(root.left == null && root.right == null) {
            if(root.val > minVal && root.val <= min) {
                min = root.val;
                flag = true;
            }
            return;
        }

        find(root.left, minVal);
        find(root.right, minVal);
    }

//     public int findSecondMinimumValue(TreeNode root) {
//         if (root.left == null) {
//             return -1;
//         }
//         var left = findSecondMinimumValue(root.left);
//         var right = findSecondMinimumValue(root.right);
//         if (left == -1 && right == -1) {
//             return root.left.val > root.right.val? root.left.val : root.right.val;
//         }

//     }
}
