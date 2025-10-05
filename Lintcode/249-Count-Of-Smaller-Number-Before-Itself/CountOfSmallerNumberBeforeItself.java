import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumberBeforeItself {
	/*
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
	public List<Integer> countOfSmallerNumberII(int[] A) {
		List<Integer> result = new ArrayList<>();
		if (A == null || A.length == 0) {
			return result;
		}

		root = build(0, 10000);
		int ans;
		for (int i = 0; i < A.length; i++) {
			ans = 0;
			if (A[i] > 0) {
				ans = query(root, 0, A[i] - 1);
			}
			modify(root, A[i], 1);
			result.add(ans);
		}

		return result;
	}

	private static class SegmentTreeNode {
		public int start, end;
		public int count;
		public SegmentTreeNode left, right;

		public SegmentTreeNode(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
			this.left = this.right = null;
		}
	}

	private SegmentTreeNode root;

	private SegmentTreeNode build(int start, int end) {
		if (start > end) {
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(start, end, 0);

		if (start != end) {
			int mid = (start + end) / 2;
			root.left = build(start, mid);
			root.right = build(mid + 1, end);
		}

		return root;
	}

	private int query(SegmentTreeNode root, int start, int end) {
		if (start == root.start && end == root.end) {
			return root.count;
		}

		int leftCount = 0;
		int rightCount = 0;

		int mid = (root.start + root.end) / 2;
		if (start <= mid) {
			if (end > mid) {
				leftCount = query(root.left, start, mid);
			} else {
				leftCount = query(root.left, start, end);
			}
		}

		if (end > mid) {
			if (start <= mid) {
				rightCount = query(root.right, mid + 1, end);
			} else {
				rightCount = query(root.right, start, end);
			}
		}

		return leftCount + rightCount;
	}

	private void modify(SegmentTreeNode root, int index, int value) {
		if (root.start == index && root.end == index) {
			root.count += value;
			return;
		}

		int mid = (root.start + root.end) / 2;
		if (index >= root.start && index <= mid) {
			modify(root.left, index, value);
		}

		if (index <= root.end && index > mid) {
			modify(root.right, index, value);
		}

		root.count = root.left.count + root.right.count;
	}
}
