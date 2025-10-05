import java.util.Collections;
import java.util.PriorityQueue;

public class DataStreamMedian {
	/**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
	public int[] medianII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[] {};
		}
		int[] res = new int[nums.length];
		int cur = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length + 1, Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length);
		for (int i : nums) {
			if (maxHeap.isEmpty() || i < maxHeap.peek()) {
				maxHeap.offer(i);
			} else {
				minHeap.offer(i);
			}
			if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}
			res[cur++] = maxHeap.peek();
		}
		return res;
	}
}
