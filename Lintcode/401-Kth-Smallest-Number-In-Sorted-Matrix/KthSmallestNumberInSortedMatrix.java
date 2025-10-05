import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumberInSortedMatrix {
	/**
	 * @param matrix
	 *            : a matrix of integers
	 * @param k
	 *            : an integer
	 * @return: the kth smallest number in the matrix
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		Queue<Tuple> minHeap = new PriorityQueue<>();
		for (int j = 0; j < n; j++) {
			minHeap.offer(new Tuple(0, j, matrix[0][j]));
		}

		for (int i = 0; i < k - 1; i++) {
			Tuple t = minHeap.poll();
			if (t.x == m - 1) {
				continue;
			}
			minHeap.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
		}

		return minHeap.poll().val;
	}

	private static class Tuple implements Comparable<Tuple> {
		public int x;
		public int y;
		public int val;

		public Tuple(int i, int j, int v) {
			x = i;
			y = j;
			val = v;
		}

		public int compareTo(Tuple t) {
			return this.val - t.val;
		}
	}
}
