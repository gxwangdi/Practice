
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeQuery {
	/**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNodeII root, int start, int end) {
        if (start == root.start && end == root.end) {
            return root.max;
        }
        
        // int mid = root.start + (root.end - root.start)/2;
        int mid = (root.start + root.end)/2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        if (start <= mid) {
            if (end > mid) {
                leftMax = query(root.left, start, mid);
            } else {
                leftMax = query(root.left, start, end);
            }
        }
        if (end > mid) {
            if (start > mid) {
                rightMax = query(root.right, start, end);
            } else {
                // Note "mid+1" could cause inconsistent state, based on how segment tree is built. 
                rightMax = query(root.right, mid+1, end);  
            }
        }
        return Math.max(leftMax, rightMax);
        
        // Need to figure out why this does not work. 
        // if (end <= mid) {
        //     return query(root.left, start, end);
        // }
        // if (start > mid) {
        //     return query(root.right, start, end);
        // }
        // return Math.max(query(root.left, start, mid), query(root.right, mid+1, end));         
    }
}
