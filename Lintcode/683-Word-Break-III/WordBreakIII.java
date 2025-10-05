import java.util.Set;

public class WordBreakIII {
	/*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
	public int wordBreak3(String s, Set<String> dict) {
		int result = 0;
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return result;
		}
		int maxLen = getMaxLength(dict);
		result += dfs(s, 0, maxLen, dict);
		return result;
	}// end of wordBreak3

	private int getMaxLength(Set<String> dict) {
		int len = 0;
		for (String s : dict) {
			len = Math.max(len, s.length());
		}
		return len;
	}// end of getMaxLength

	private int dfs(String src, int startIndex, int max, Set<String> dict) {
		if (startIndex == src.length()) {
			return 1;
		}
		if (startIndex > src.length()) {
			return 0;
		}
		max = Math.min(max, src.length() - startIndex);
		int result = 0;
		for (int i = 1; i < max + 1; i++) {
			if (dict.contains(src.substring(startIndex, startIndex + i))) {
				result += dfs(src, startIndex + i, max, dict);
			}
		}
		return result;
	}// end of dfs
}
