/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return getBalanceBST(nums, 0, nums.length-1);
    }
    
    private TreeNode getBalanceBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (start == end) {
            return root;
        }
        root.left = getBalanceBST(nums, start, mid-1);
        root.right = getBalanceBST(nums, mid+1, end);
        return root;
    }
}


