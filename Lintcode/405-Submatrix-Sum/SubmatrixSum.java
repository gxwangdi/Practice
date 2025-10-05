import java.util.HashMap;
import java.util.Map;

public class SubmatrixSum {
	/**
	 * @param matrix an integer matrix
	 * @return the coordinate of the left-up and right-down number
	 */
	public int[][] submatrixSum(int[][] matrix) {
		int[][] result = new int[2][2];
		int M = matrix.length;
		if (M == 0) {
			return result;
		}
		int N = matrix[0].length;
		if (N == 0) {
			return result;
		}

		// sum[i][j] = Sum{0...i, 0...j}.
		int[][] sum = new int[M + 1][N + 1];
		for (int j = 0; j <= N; j++) {
			sum[0][j] = 0;
		}
		for (int i = 1; i <= M; i++) {
			sum[i][0] = 0;
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
			}
		} //

		for (int i1 = 0; i1 < M; i1++) {
			for (int i2 = i1 + 1; i2 <= M; i2++) {
				Map<Integer, Integer> map = new HashMap<>();
				for (int j = 0; j <= N; j++) {
					int diff = sum[i2][j] - sum[i1][j];
					if (map.containsKey(diff)) {
						int k = map.get(diff);
						result[0][0] = i1;
						result[0][1] = k;
						result[1][0] = i2 - 1;
						result[1][1] = j - 1;
						return result;
					} else {
						map.put(diff, j);
					}
				}
			}
		}
		return result;
	}
}
