import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
	/**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
	public List<Integer> medianSlidingWindow(int[] nums, int k) {

		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0 || k <= 0) {
			return res;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k + 1);

		int cur = 0;
		while (cur < nums.length) {
			if (maxHeap.isEmpty() || nums[cur] < maxHeap.peek()) {
				maxHeap.offer(nums[cur]);
			} else {
				minHeap.offer(nums[cur]);
			}

			if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}

			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}

			if (maxHeap.size() + minHeap.size() > k) {
				int remove = nums[cur - k];

				if (remove <= maxHeap.peek()) {
					maxHeap.remove(remove);
				} else {
					minHeap.remove(remove);
				}
				if (minHeap.size() > maxHeap.size()) {
					maxHeap.offer(minHeap.poll());
				}

				if (maxHeap.size() > minHeap.size() + 1) {
					minHeap.offer(maxHeap.poll());
				}

			}
			if (maxHeap.size() + minHeap.size() == k) {
				res.add(maxHeap.peek());
			}
			cur++;
		}
		return res;
	}
}
