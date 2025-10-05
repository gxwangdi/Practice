
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeBuild {
	/**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
	public SegmentTreeNode build(int start, int end) {
		if (start > end) {
			return null;
		}

		SegmentTreeNode stn = new SegmentTreeNode(start, end);
		if (start == end) {
			return stn;
		}
		stn.left = build(start, start + (end - start) / 2);
		stn.right = build(start + (end - start) / 2 + 1, end);
		return stn;
	}
}
