
public class RegularExpressionMatching {
	/**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.isEmpty() || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} //

		while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));
	}
}
