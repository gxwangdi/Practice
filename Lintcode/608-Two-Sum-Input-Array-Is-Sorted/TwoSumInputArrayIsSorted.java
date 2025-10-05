
public class TwoSumInputArrayIsSorted {
	/** 
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return new int[2];
		}
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			int sum = nums[l] + nums[r];
			if (sum == target) {
				int[] result = { l + 1, r + 1 };
				return result;
			}
			if (sum < target) {
				l++;
				continue;
			}
			r--;
		}
		return new int[2];
	}
}
