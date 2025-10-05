import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	/**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    /*
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return rst;

		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		while (count * 2 < rows && count * 2 < cols) {
			for (int i = count; i < cols - count; i++)
				rst.add(matrix[count][i]);

			for (int i = count + 1; i < rows - count; i++)
				rst.add(matrix[i][cols - count - 1]);

			if (rows - 2 * count == 1 || cols - 2 * count == 1) // if only one row /col remains
				break;

			for (int i = cols - count - 2; i >= count; i--)
				rst.add(matrix[rows - count - 1][i]);

			for (int i = rows - count - 2; i >= count + 1; i--)
				rst.add(matrix[i][count]);

			count++;
		}
		return rst;
	}*/

	// Iterative approach
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		while (count * 2 < rows && count * 2 < cols) {
			for (int i = count; i < cols - count; i++) {
				res.add(matrix[count][i]);
			}
			for (int i = count + 1; i < rows - count; i++) {
				res.add(matrix[i][cols - count - 1]);
			}
			if (rows - 2 * count == 1 || cols - 2 * count == 1) {
				break;
			}
			for (int i = cols - count - 2; i >= count; i--) {
				res.add(matrix[rows - count - 1][i]);
			}
			for (int i = rows - count - 2; i >= count + 1; i--) {
				res.add(matrix[i][count]);
			}
			count++;
		}
		return res;
	}

	/* // Recursive approach. Never assume the matrix.length == matrix[0].length;
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int m = matrix.length;
		spiralPrint(matrix, 0, m, res);
		return res;
	}

	private void spiralPrint(int[][] matrix, int pos, int length, List<Integer> res) {
		if (length <= 0) {
			return;
		}
		if (length == 1) {
			res.add(matrix[pos][pos]);
			return;
		}

		int row = pos;
		int col = pos;
		int i = 0;
		while (i < length - 1) {
			res.add(matrix[row][col + i]);
			i++;
		}
		int j = 0;
		while (j < length - 1) {
			res.add(matrix[row + j][col + i]);
			j++;
		}
		while (i > 0) {
			res.add(matrix[row + j][col + i]);
			i--;
		}
		while (j > 0) {
			res.add(matrix[row + j][col]);
			j--;
		}
		spiralPrint(matrix, pos + 1, length - 2, res);
	}*/
}
