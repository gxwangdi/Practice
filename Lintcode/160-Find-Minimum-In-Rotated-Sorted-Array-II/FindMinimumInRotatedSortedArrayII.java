


public class FindMinimumInRotatedSortedArrayII {
	/**
	 * @param num
	 *            : a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return Integer.MIN_VALUE;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			min = Math.min(min, num[i]);
		}
		return min;
	}
}
