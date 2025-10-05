import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[]{};
        }
        int[] res = new int[nums.length-k+1];
        int cur = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<nums.length; i++) {
            int now = nums[i];
            // Remove 
            while (!deque.isEmpty() && now > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offer(now);
            if (i+1 > k && deque.peekFirst() == nums[i-k]) {
                deque.pollFirst();
            }
            if (i+1 >= k) {
                res[cur++] = deque.peekFirst();
            }
        }
        return res;
    }
}



