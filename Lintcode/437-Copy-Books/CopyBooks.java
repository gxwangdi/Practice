
public class CopyBooks {
	/*
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
	public int copyBooks(int[] pages, int k) {
		int l = 0;
		int r = 9999999;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (search(mid, pages, k))
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	private boolean search(int total, int[] page, int k) {
		int count = 1;
		int sum = 0;
		for (int i = 0; i < page.length;) {
			if (sum + page[i] <= total) {
				sum += page[i++];
			} else if (page[i] <= total) {
				sum = 0;
				count++;
			} else {
				return false;
			}
		}
		return count <= k;
	}
	
//	public int copyBooks(int[] pages, int k) {
//		if (pages == null || pages.length == 0) {
//			return 0;
//		}
//
//		if (k < 1) {
//			return -1;
//		}
//
//		int n = pages.length;
//		int[][] T = new int[n + 1][k + 1];
//
//		for (int j = 1; j <= k; j++) {
//			T[1][j] = pages[0];
//		}
//
//		int sum = 0;
//		for (int i = 1; i <= n; i++) {
//			sum += pages[i - 1];
//			T[i][1] = sum;
//		}
//
//		for (int i = 2; i <= n; i++) {
//			for (int j = 2; j <= k; j++) {
//				if (j > i) {
//					T[i][j] = T[i][j - 1];
//					continue;
//				}
//				int min = Integer.MAX_VALUE;
//				for (int h = j - 1; h <= i; h++) {
//					int temp = Math.max(T[h][j - 1], T[i][1] - T[h][1]);
//					min = Math.min(min, temp);
//				}
//				T[i][j] = min;
//			}
//		}
//
//		return T[n][k];
//	}
}
