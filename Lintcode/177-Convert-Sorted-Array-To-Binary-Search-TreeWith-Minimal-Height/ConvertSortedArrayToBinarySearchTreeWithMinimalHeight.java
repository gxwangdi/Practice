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
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = buildBST(nums, 0, nums.length - 1);
        return root;
    }
    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            TreeNode node = new TreeNode(nums[start]);
            return node;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (start < mid) {
            root.left = buildBST(nums, start, mid - 1);
        }
        if (mid < end) {
            root.right = buildBST(nums, mid + 1, end);
        }
        return root;
    }
}
