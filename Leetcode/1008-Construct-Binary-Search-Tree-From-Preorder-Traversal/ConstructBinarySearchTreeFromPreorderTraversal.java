/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++) {
        if(preorder[i] > node.val)
            break;
        }

        node.left = helper(preorder, start+1, i-1);
        node.right = helper(preorder, i, end);
        return node;
    }

    // public TreeNode bstFromPreorder(int[] preorder) {
    //     if (preorder == null) {
    //         return null;
    //     }
    //     return bstFromPreorder(preorder, 0, preorder.length-1);
    // }

    // [start, end]
    // private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
    //     if (end <0 || start > end) {
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(preorder[start]);
    //     int index = BinarySearch(preorder, start+1, end, preorder[start]);
    //     if (index == -2) {
    //         return root;
    //     }
    //     if (index == -1) {
    //         root.left = bstFromPreorder(preorder, start+1, preorder.length-1);
    //         root.right = null;
    //     } else {
    //         root.left = bstFromPreorder(preorder, start+1, index-1);
    //         root.right = bstFromPreorder(preorder, index, preorder.length-1);
    //     }
    //     return root;
    // }

    /**
     * @start the start index for the search
     * @pivot the pivot
     * @return the index of the first element in [start, end] that is bigger than pivot, -1 is does not exist, -2 if out of bound(start > end).
     */
    // private int BinarySearch(int[] preorder, int start, int end, int pivot) {
    //     int index = -2;
    //     if (start > end) {
    //         return index;
    //     }
    //     index =-1;
    //     int mid;
    //     while (start < end - 1) {
    //         mid = start + (end-start)/2;
    //         if (preorder[mid] < pivot) {
    //             start = mid;
    //             continue;
    //         }
    //         end = mid;
    //     }
    //     if (preorder[start] > pivot) {
    //         index = start;
    //     } else if (preorder[end] > pivot) {
    //         index = end;
    //     }
    //     return index;
    // }
}
