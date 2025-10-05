public class ContainerWithMostWater {
	/**
	 * @param heights
	 *            : an array of integers
	 * @return: an integer
	 */
	public int maxArea(int[] heights) {
		int max = 0;
		if (heights == null || heights.length < 2) {
			return max;
		}

		int left = 0;
		int right = heights.length - 1;
		while (left < right) {
			int h = Math.min(heights[left], heights[right]);
			int w = right - left;
			max = Math.max(max, w * h);
			if (heights[left] < heights[right]) {
				int cur = left;
				while (left < right && heights[left] <= heights[cur]) {
					left++;
				}
			} else {
				int cur = right;
				while (left < right && heights[right] <= heights[cur]) {
					right--;
				}
			}
		}
		return max;
	}// end of maxArea
}
