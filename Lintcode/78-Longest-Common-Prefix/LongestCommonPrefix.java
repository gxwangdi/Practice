public class LongestCommonPrefix {
	/**
	 * @param strs: A list of strings
	 * @return: The longest common prefix
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length < 2) {
			return strs[0];
		}

		String lcp = getLCP(strs[0], strs[1]);
		for (int i = 2; i < strs.length; i++) {
			lcp = getLCP(lcp, strs[i]);
			if (lcp.length() == 0) {
				break;
			}
		}
		return lcp;
	}

	private String getLCP(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()
				&& s1.charAt(i) == s2.charAt(j)) {
			sb.append(s1.charAt(i));
			i++;
			j++;
		}
		return sb.toString();
	}
}
