
public class IntervalSumII {
	private static class SegmentTreeNode {
		public int start;
		public int end;
		public int sum;
		public SegmentTreeNode left;
		public SegmentTreeNode right;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.sum = 0;
			this.left = null;
			this.right = null;
		}
	}// end of SegmentTreeNode class

	private SegmentTreeNode root;

	/*
	 * @param A: An integer array
	 */
	public IntervalSumII(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        root = buildTree(0, A.length - 1, A);
    }

	private SegmentTreeNode buildTree(int start, int end, int[] A) {
		if (start > end) {
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(start, end);

		if (start == end) {
			root.sum = A[start];
		} else {
			int middle = start + (end - start) / 2;

			root.left = buildTree(start, middle, A);
			root.right = buildTree(middle + 1, end, A);

			root.sum = root.left.sum + root.right.sum;
		}

		return root;
	}

	/*
	 * @param start: An integer
	 * 
	 * @param end: An integer
	 * 
	 * @return: The sum from start to end
	 */
	public long query(int start, int end) {
		return query(root, start, end);
	}

	private long query(SegmentTreeNode node, int start, int end) {
		if (node == null) {
			return 0;
		}

		if (start <= node.start && end >= node.end) {
			return node.sum;
		}

		int middle = node.start + (node.end - node.start) / 2;

		if (end <= middle) {
			return query(node.left, start, end);
		} else if (start > middle) {
			return query(node.right, start, end);
		} else {
			return query(node.left, start, middle) + query(node.right, middle + 1, end);
		}
	}

	/*
	 * @param index: An integer
	 * 
	 * @param value: An integer
	 * 
	 * @return: nothing
	 */
	public void modify(int index, int value) {
		modify(root, index, value);
	}

	private void modify(SegmentTreeNode root, int index, int value) {
		if (root == null) {
			return;
		}
		if (index < root.start || index > root.end) {
			return;
		}

		if (root.start == index && root.end == index) {
			root.sum = value;
			return;
		}

		int middle = root.start + (root.end - root.start) / 2;

		if (index <= middle) {
			modify(root.left, index, value);
		} else {
			modify(root.right, index, value);
		}

		root.sum = root.left.sum + root.right.sum;
	}
}
