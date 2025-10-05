import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * @param s: a string
	 * @return: an integer
	 */
	public int lengthOfLongestSubstring(String s) {
		int[] m = new int[256];
		Arrays.fill(m, -1);
		int res = 0;
		int left = -1;
		for (int i = 0; i < s.length(); i++) {
			left = Math.max(left, m[s.charAt(i)]);
			m[s.charAt(i)] = i;
			res = Math.max(res, i - left);
		}
		return res;
	}
}
