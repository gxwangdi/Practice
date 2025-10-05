public class SortIntegersII {
	/**
	 * @param A
	 *            an integer array
	 * @return void
	 */
	// Quick sort
//	public void sortIntegers2(int[] A) {
//		if (A == null || A.length < 2) {
//			return;
//		}
//		quickSort(A, 0, A.length - 1);
//	}
//
//	private void quickSort(final int[] A, int low, int high) {
//		if (low >= high) {
//			return;
//		}
//		int p = quickPartition(A, low, high);
//		quickSort(A, low, p);
//		quickSort(A, p + 1, high);
//	}
//
//	private int quickPartition(final int[] A, int low, int high) {
//		int pivot = A[low];
//		int i = low - 1;
//		int j = high + 1;
//		while (true) {
//			do {
//				i++;
//			} while (A[i] < pivot);
//			do {
//				j--;
//			} while (A[j] > pivot);
//			if (i >= j) {
//				return j;
//			}
//			swap(A, i, j);
//		}
//	}

	private void swap(final int[] src, final int i, final int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}

	// Merge sort
//	public void sortIntegers2(int[] A) {
//		if (A == null || A.length < 2) {
//			return;
//		}
//		mergeSort(A, 0, A.length - 1);
//	}
//
//	private void mergeSort(final int[] A, final int low, final int high) {
//		if (low >= high) {
//			return;
//		}
//		int m = low + (high - low) / 2;
//		mergeSort(A, low, m);
//		mergeSort(A, m + 1, high);
//
//		merge(A, low, m, high);
//	}
//
//	private void merge(final int[] A, int low, int m, int high) {
//		int i, j, k;
//		int n1 = m - low + 1;
//		int n2 = high - m;
//
//		int[] L = new int[n1];
//		int[] R = new int[n2];
//
//		for (i = 0; i < n1; i++) {
//			L[i] = A[low + i];
//		}
//		for (j = 0; j < n2; j++) {
//			R[j] = A[m + 1 + j];
//		}
//
//		i = 0;
//		j = 0;
//		k = low;
//		while (i < n1 && j < n2) {
//			if (L[i] <= R[j]) {
//				A[k] = L[i];
//				i++;
//			} else {
//				A[k] = R[j];
//				j++;
//			}
//			k++;
//		}
//		while (i < n1) {
//			A[k] = L[i];
//			i++;
//			k++;
//		}
//		while (j < n2) {
//			A[k] = R[j];
//			j++;
//			k++;
//		}
//	}

	// Heap sort
	// Do not use the PriorityQueue facility in Java here.
	public void sortIntegers2(int[] A) {
		if (A == null || A.length < 2) {
			return;
		}
		int n = A.length;

		// Build heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(A, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;

			// call max heap on the reduced heap
			heapify(A, i, 0);
		}
	}

	private void heapify(final int[] A, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && A[l] > A[largest]) {
			largest = l;
		}

		if (r < n && A[r] > A[largest]) {
			largest = r;
		}

		if (largest != i) {
			swap(A, i, largest);
			heapify(A, n, largest);
		}
	}
}
