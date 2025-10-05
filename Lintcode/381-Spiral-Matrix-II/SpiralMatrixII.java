
public class SpiralMatrixII {
	/**
     * @param n an integer
     * @return a square matrix
     */
	public int[][] generateMatrix(int n) {
		if (n < 1) {
			return new int[0][];
		}
		int[][] res = new int[n][n];
		int count = 1;
		generateMatrix(res, 0, n, count);
		return res;
	}

	private void generateMatrix(int[][] arr, int pos, int length, int count) {
		if (length < 1) {
			return;
		}
		if (length == 1) {
			arr[pos][pos] = count;
			return;
		}
		int i = 0;
		int j = 0;
		while (i < length - 1) {
			arr[pos][pos + i] = count;
			count++;
			i++;
		}
		while (j < length - 1) {
			arr[pos + j][pos + i] = count;
			count++;
			j++;
		}
		while (i > 0) {
			arr[pos + j][pos + i] = count;
			count++;
			i--;
		}
		while (j > 0) {
			arr[pos + j][pos] = count;
			count++;
			j--;
		}
		generateMatrix(arr, pos + 1, length - 2, count);
	}
}
