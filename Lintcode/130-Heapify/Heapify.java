
public class Heapify {
	/**
     * @param A: Given an integer array
     * @return: void
     */
	public void heapify(int[] A) {
		if (A == null || A.length < 2) {
			return;
		}
		for (int i = A.length / 2; i >= 0; i--) {
			siftDown(A, i);
		}
	}// end of heapify     
    
	private void siftDown(int[] A, int i) {
		while (i < A.length) {
			int smallest = i;
			if (i * 2 + 1 < A.length && A[i * 2 + 1] < A[smallest]) {
				smallest = i * 2 + 1;
			}
			if (i * 2 + 2 < A.length && A[i * 2 + 2] < A[smallest]) {
				smallest = i * 2 + 2;
			}
			if (smallest == i) {
				break;
			}
			int temp = A[smallest];
			A[smallest] = A[i];
			A[i] = temp;

			i = smallest;
		}
	}
}
