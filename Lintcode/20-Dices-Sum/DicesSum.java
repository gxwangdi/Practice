import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DicesSum {
	/**
	 * @param n an integer
	 * @return a list of Map.Entry<sum, probability>
	 */
	public List<Map.Entry<Integer, Double>> dicesSum(int n) {

		List<Map.Entry<Integer, Double>> result = new ArrayList<Map.Entry<Integer, Double>>();
		if (n < 1) {
			return result;
		}

		double[][] matrix = new double[n + 1][6 * n + 1];
		for (int i = 1; i <= 6; i++) {
			matrix[1][i] = 1.0 / 6;
		}

		for (int i = 2; i <= n; i++) {

			for (int j = i; j <= 6 * i; j++) {

				for (int k = 1; k <= 6; k++) {
					if (k <= j - i + 1) {
						matrix[i][j] += matrix[i - 1][j - k];
					}
				}
				matrix[i][j] /= 6.0;
			}
		}

		for (int i = n; i <= 6 * n; i++) {
			result.add(new AbstractMap.SimpleEntry<Integer, Double>(i, matrix[n][i]));
		}
		return result;
	}
}
