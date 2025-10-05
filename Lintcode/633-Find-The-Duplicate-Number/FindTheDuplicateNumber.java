public class FindTheDuplicateNumber {
	/**
	 * @param nums
	 *            an array containing n + 1 integers which is between 1 and n
	 * @return the duplicate one
	 */
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];

			if (slow == fast) {
				break;
			}
		}
		fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[fast];
			if (slow == fast) {
				return fast;
			}
		}
	}
}
