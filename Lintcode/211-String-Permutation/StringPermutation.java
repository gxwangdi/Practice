
public class StringPermutation {
	/**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
	public boolean stringPermutation(String A, String B) {
		if (A == null || B == null || A.length() != B.length()) {
			return false;
		}
		int[] chars = new int[256];
		for (int i = 0; i < A.length(); i++) {
			int c = A.charAt(i);
			chars[c]++;
			c = B.charAt(i);
			chars[c]--;
		}
		for (int i : chars) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
