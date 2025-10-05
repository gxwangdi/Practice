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

class SegmentTreeNode {
	int min;
	int start;
	int end;
	SegmentTreeNode left;
	SegmentTreeNode right;

	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.min = Integer.MAX_VALUE;
		this.left = null;
		this.right = null;
	}
}

public class IntervalMinimumNumber {
	/**
	 * @param A, queries: Given an integer array and an query list
	 * @return: The result list
	 */
	public List<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
		List<Integer> res = new ArrayList<Integer>();
		root = buildTree(A, 0, A.length - 1);
		query(res, queries);
		return res;
	}

	public SegmentTreeNode buildTree(int[] A, int start, int end) {
		SegmentTreeNode cur = new SegmentTreeNode(start, end);
		if (start == end) {
			cur.min = A[start];
		} else {
			int mid = (start + end) / 2;
			cur.left = buildTree(A, start, mid);
			cur.right = buildTree(A, mid + 1, end);
			cur.min = Math.min(cur.left.min, cur.right.min);
		}
		return cur;
	}

	public void query(List<Integer> res, List<Interval> queries) {
		for (Interval interval : queries) {
			int result = queryTree(root, interval.start, interval.end);
			res.add(result);
		}
	}

	public int queryTree(SegmentTreeNode cur, int start, int end) {
		if (start == cur.start && end == cur.end) {
			return cur.min;
		}
		int mid = (cur.start + cur.end) / 2;
		if (end <= mid)
			return queryTree(cur.left, start, end);
		else if (start > mid)
			return queryTree(cur.right, start, end);
		else
			return Math.min(queryTree(cur.left, start, mid),
					queryTree(cur.right, mid + 1, end));
	}

	SegmentTreeNode root;
}
