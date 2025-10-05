import java.util.PriorityQueue;


public class KthLargestInNArray {
	/**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
	public int KthInArrays(int[][] arrays, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				q.offer(arrays[i][j]);
				if (q.size() > k) {
					q.poll();
				}
			}
		}
		return q.peek();
	}
}
