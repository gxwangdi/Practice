
public class SingleNumber {
	/**
     *@param A : an integer array
     *return : a integer 
     */
	public int singleNumber(int[] nums) {
		int res = 0;
		if (nums == null || nums.length == 0) {
			return res;
		}
		for (int i : nums) {
			res = res ^ i;
		}
		return res;
	}
}
