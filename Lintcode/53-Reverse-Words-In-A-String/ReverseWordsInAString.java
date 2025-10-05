
public class ReverseWordsInAString {
	/**
     * @param s : A string
     * @return : A string
     */
	public String reverseWords(String s) {
		if (s == null || s.trim().length() == 0) {
			return s;
		}

		String[] strs = s.split("[ ]+");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			if (sb.length() != 0) {
				sb.append(" ");
			}
			sb.append(strs[i]);
		}
		return sb.toString();
	}
}
