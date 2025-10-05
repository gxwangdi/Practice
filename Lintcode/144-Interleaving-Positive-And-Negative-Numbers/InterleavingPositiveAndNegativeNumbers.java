public class InterleavingPositiveAndNegativeNumbers {
	/**
	 * @param A : An integer array.
	 * @return: void
	 */
	public void rerange(int[] A) {
		int posNum = 0, posIndex = 1, negIndex = 0;
		for (int a : A) {
			posNum += a > 0 ? 1 : 0;
		}
		if (posNum * 2 > A.length) {
			posIndex = 0;
			negIndex = 1;
		}
		while (posIndex < A.length && negIndex < A.length) {
			while (posIndex < A.length && A[posIndex] > 0)
				posIndex += 2;
			while (negIndex < A.length && A[negIndex] < 0)
				negIndex += 2;
			if (posIndex < A.length && negIndex < A.length) {
				swap(A, posIndex, negIndex);
				posIndex += 2;
				negIndex += 2;
			}
		}
	}

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
