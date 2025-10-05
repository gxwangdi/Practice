import java.util.ArrayList;
import java.util.List;



/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class IntervalSum {
	/**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    /* // Prefix Sum Approach.
    public List<Long> intervalSum(int[] A, 
                                       List<Interval> queries) {
        long[] prefixSum = new long[A.length+1];
        for (int i=0; i<A.length; i++) {
            prefixSum[i+1] = prefixSum[i] + A[i];
        }
        List<Long> res = new ArrayList<>();
        for (Interval interval : queries) {
            int start = interval.start;
            int end = interval.end;
            long result = prefixSum[end+1] - prefixSum[start];
            res.add(result);
        }
        return res;
    }*/
    
    // Segment Tree Approach
	public List<Long> intervalSum(int[] A, List<Interval> queries) {
		List<Long> res = new ArrayList<>();
		root = build(A, 0, A.length - 1);
		for (Interval interval : queries) {
			int start = interval.start;
			int end = interval.end;
			res.add(query(root, start, end));
		}
		return res;
	}

	private SegmentTreeNode root;

	class SegmentTreeNode {
		long sum;
		int start;
		int end;
		SegmentTreeNode left;
		SegmentTreeNode right;

		public SegmentTreeNode(int start, int end) {
			this.sum = 0;
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
		}
	}

	public SegmentTreeNode build(int[] A, int start, int end) {
		SegmentTreeNode cur = new SegmentTreeNode(start, end);
		if (start == end) {
			cur.sum = A[start];
		} else {
			int mid = (start + end) / 2;
			cur.left = build(A, start, mid);
			cur.right = build(A, mid + 1, end);
			cur.sum = cur.left.sum + cur.right.sum;
		}
		return cur;
	}

	public Long query(SegmentTreeNode cur, int start, int end) {
		if (cur.start == start && cur.end == end)
			return cur.sum;
		int mid = (cur.start + cur.end) / 2;
		if (end <= mid)
			return query(cur.left, start, end);
		else if (start > mid)
			return query(cur.right, start, end);
		else
			return query(cur.left, start, mid) + query(cur.right, mid + 1, end);
	}
}
