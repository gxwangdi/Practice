import java.util.Arrays;

public class MaximalRectangle {
	/*
	 * @param matrix: a boolean 2D matrix
	 * 
	 * @return: an integer
	 */
	public int maximalRectangle(boolean[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int n = matrix.length;
		int m = matrix[0].length;
		int[] height = new int[m];
		int[] left = new int[m];
		int[] right = new int[m];
		Arrays.fill(right, m - 1);

		int max = 0;
		for (int i = 0; i < n; i++) {
			int curtLeft = 0;
			int curtRight = m - 1;

			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == true) {
					height[j]++;
					left[j] = Math.max(left[j], curtLeft);
				} else {
					height[j] = 0;
					left[j] = 0;
					curtLeft = j + 1;
				}
			}

			for (int j = m - 1; j >= 0; j--) {
				if (matrix[i][j] == true) {
					right[j] = Math.min(right[j], curtRight);
				} else {
					right[j] = m;
					curtRight = j - 1;
				}
			}

			for (int j = 0; j < m; j++) {
				int area = (right[j] - left[j] + 1) * height[j];
				max = Math.max(max, area);
			}
		}

		return max;
	}
	
	
	// TLE  
	/*
	public int maximalRectangle(boolean[][] matrix) {
		int area = 0;
		int rowN = matrix.length;
		if (rowN == 0) {
			return area;
		}
		int colN = matrix[0].length;
		int[] h = new int[colN];

		for (int i = 0; i < rowN; i++) {
			Stack<Integer> s = new Stack<Integer>();
			for (int j = 0; j < colN; j++) {
				h[j] = matrix[i][j] == false ? 0 : h[j] + 1;
			}
			int j = 0;
			while (j < colN) {
				if (s.isEmpty() || h[j] >= h[s.peek()]) {
					s.push(j++);
				} else {
					int lastInd = s.pop();
					int cur = h[lastInd] * (s.isEmpty() ? j : (j - s.peek() - 1));
					area = Math.max(cur, area);
				}
			}
			while (!s.isEmpty()) {
				int lastInd = s.pop();
				int cur = h[lastInd] * (s.isEmpty() ? j : (j - s.peek() - 1));
				area = Math.max(cur, area);
			}
		}
		return area;
	}*/
}
