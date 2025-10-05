
public class WoodCut {
	/** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0) {
			return 0;
		}
		int end = Integer.MIN_VALUE;
		long sum = 0;
		for (int i : L) {
			end = Math.max(end, i);
			sum += i;
		}
		if (sum < k) {
			return 0;
		}
		int start = 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (pieceCount(L, mid) >= k) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (pieceCount(L, end) >= k) {
			return end;
		}
		if (pieceCount(L, start) >= k) {
			return start;
		}
		return -1;
	}

	private int pieceCount(int[] L, int length) {
		int sum = 0;
		for (int i : L) {
			sum += i / length;
		}
		return sum;
	}
}
