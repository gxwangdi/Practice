
public class TrappingRainWater {
	/**
     * @param heights: an array of integers
     * @return: a integer
     */
	public int trapRainWater(int[] heights) {
		if (heights == null || heights.length < 3) {
			return 0;
		}
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];

		int max = heights[0];
		for (int i = 0; i < n; i++) {
			max = Math.max(max, heights[i]);
			left[i] = Math.max(max, heights[i]);
		}

		max = heights[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			max = Math.max(max, heights[i]);
			right[i] = Math.max(max, heights[i]);
		}

		max = 0;
		for (int i = 1; i < n - 1; i++) {
			max += Math.min(left[i], right[i]) - heights[i];
		}
		return max;
	}
}
