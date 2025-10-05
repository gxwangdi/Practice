import java.util.Arrays;

public class TriangleCount {
	/**
     * @param S: A list of integers
     * @return: An integer
     */
	public int triangleCount(int S[]) {
		if (S == null || S.length < 3)
			return 0;

		Arrays.sort(S);
		int ans = 0;
		int left;
		int right;
		for (int i = 2; i < S.length; i++) {
			left = 0;
			right = i - 1;
			while (left < right) {
				if (S[left] + S[right] > S[i]) {
					ans = ans + (right - left);
					right--;
				} else {
					left++;
				}
			}
		}
		return ans;
	}
}
