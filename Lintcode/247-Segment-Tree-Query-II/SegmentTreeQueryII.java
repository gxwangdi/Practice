
/* Definition of SegmentTreeNode: */
class SegmentTreeNodeIII {
     public int start, end, count;
     public SegmentTreeNodeIII left, right;
     public SegmentTreeNodeIII(int start, int end, int count) {
         this.start = start;
         this.end = end;
         this.count = count;
         this.left = this.right = null;
     }
 }
public class SegmentTreeQueryII {
	/**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNodeIII root, int start, int end) {
        if ( start>end || root == null) {
            return 0;
        }
        if (start <= root.start && root.end <= end) {
            return root.count;
        }
        int mid = (root.start + root.end)/2;
        int leftSum = 0;
        int rightSum = 0; 
        if (start <= mid) { 
        // Keep in mind that as per segment tree def, this should be <=, not <.
            if (end < mid) {
                leftSum = query(root.left, start, end);
            } else {
                leftSum = query(root.left, start, mid);
            }
        }
        if (end > mid) {
            if (start > mid) {
                rightSum = query(root.right, start, end);
            } else {
                rightSum = query(root.right, mid+1, end);
            }
        }
        return leftSum + rightSum;
    }
}
