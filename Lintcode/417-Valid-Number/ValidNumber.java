
public class ValidNumber {
	/**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
	public boolean isNumber(String s) {
		if (s == null) {
			return false;
		}
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		int cur = 0;
		if (s.charAt(cur) == '+' || s.charAt(cur) == '-') {
			cur++;
		}
		boolean num = false;
		boolean exp = false;
		boolean dot = false;
		while (cur < s.length()) {
			char c = s.charAt(cur);
			if (Character.isDigit(c)) {
				num = true;
			} else if (c == '+' || c == '-') {
				if (s.charAt(cur - 1) != 'e') {
					return false;
				}
			} else if (c == 'e') {
				if (exp || !num) {
					return false;
				}
				exp = true;
				num = false;
			} else if (c == '.') {
				if (exp || dot) {
					return false;
				}
				dot = true;
			} else {
				return false;
			}
			cur++;
		}
		return num;
	}
}
