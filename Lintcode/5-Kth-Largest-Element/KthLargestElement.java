import java.util.Comparator;
import java.util.PriorityQueue;


public class KthLargestElement {
	/*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
     
     /*
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length <k) 
            return 0;
        
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    */
    
    
	public int kthLargestElement(int k, int[] nums) {
		if (nums == null || nums.length < k)
			return 0;

		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		};

		PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, comparator);
		for (int i : nums) {
			pq.offer(i);
		}

		for (int i = 0; i < k - 1; i++) {
			pq.poll();
		}
		return pq.poll();
	}
}
