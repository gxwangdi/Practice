import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	/**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k<=0) {
            return res;
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int i = 0;
        for (int now : nums) {
            i++;
            while (!queue.isEmpty() && now > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(now);
            if (i > k && queue.peekFirst() == nums[i-k-1]) {
                queue.pollFirst();
            }
            if (i >= k) {
                res.add(queue.peekFirst());
            }
        }
        return res;
     }
    
    /*
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue(k + 1, Collections.reverseOrder());
        int cur = 0;
        while (cur < nums.length) {
            maxHeap.offer(nums[cur]);
            if (maxHeap.size() > k) {
                int remove = nums[cur - k];
                maxHeap.remove(remove);
            }
            if (maxHeap.size() == k) {
                res.add(maxHeap.peek());
            }
            cur++;
        }
        return res;
    }*/
}
