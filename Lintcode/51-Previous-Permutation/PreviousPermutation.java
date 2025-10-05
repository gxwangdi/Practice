import java.util.List;

public class PreviousPermutation {
	/**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
	public List<Integer> previousPermuation(List<Integer> nums) {
		if (nums == null || nums.size() == 0)
			return nums;
		int i = nums.size() - 2;
		for (; i >= 0; i--) {
			if (nums.get(i) > nums.get(i + 1))
				break;
		}
		if (i >= 0) {
			int j = i;
			for (; j <= nums.size() - 2; j++) {
				if (nums.get(j + 1) >= nums.get(i))
					break;
			}
			int temp = nums.get(j);
			nums.set(j, nums.get(i));
			nums.set(i, temp);
		}
		reverse(nums, i + 1);
		return nums;
	}

	private void reverse(List<Integer> nums, int k) {
		int l = k, r = nums.size() - 1;
		while (l < r) {
			int temp = nums.get(l);
			nums.set(l, nums.get(r));
			nums.set(r, temp);
			l++;
			r--;
		}
	}
}
