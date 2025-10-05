
public class WildcardMatching {
	/**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int match = 0;
		int starIdx = -1;
		while (i < s.length()) {
			if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			}

			else if (j < p.length() && p.charAt(j) == '*') {
				starIdx = j;
				match = i;
				j++;
			}

			else if (starIdx != -1) {
				j = starIdx + 1;
				match++;
				i = match;
			}

			else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}
		return j == p.length();
	}
}
