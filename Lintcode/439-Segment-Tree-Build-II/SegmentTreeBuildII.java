
/* Definition of SegmentTreeNode: */ 
 class SegmentTreeNodeII {
      public int start, end, max;
      public SegmentTreeNodeII left, right;
      public SegmentTreeNodeII(int start, int end, int max) {
          this.start = start;
          this.end = end;
          this.max = max;
          this.left = this.right = null;
      }
  }
 
public class SegmentTreeBuildII {
	/**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNodeII build(int[] A) {
        if (A == null) {
            return null;
        }
        return build(A, 0, A.length-1);
    }
    
    private SegmentTreeNodeII build(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        SegmentTreeNodeII stn = 
            new SegmentTreeNodeII(left, right, Integer.MIN_VALUE);
        if (left == right) {
            stn.max = arr[left];
            return stn;
        }
        
        int mid = (left + right)/2;
        stn.left = build(arr, left, mid);            
        stn.right = build(arr, mid+1, right);        
        if (stn.left != null) {
            stn.max = Math.max(stn.max, stn.left.max);
        }
        if (stn.right != null) {
            stn.max = Math.max(stn.max, stn.right.max);
        }
        return stn;
    }
}
