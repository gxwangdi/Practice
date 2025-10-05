public class FirstMissingPositive {
	/**
	 * @param A
	 *            : an array of integers
	 * @return: an integer
	 */
	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0) {
				continue;
			}
			if (A[i] > A.length) {
				continue;
			}
			if (A[A[i] - 1] == A[i]) {
				continue;
			}
			int temp = A[i];
			A[i] = A[temp - 1];
			A[temp - 1] = temp;
			// pay attention to this! need to check A[i]`s new value in the next
			// iteration.
			i--;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}
}
