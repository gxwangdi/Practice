
public class StringToIntegerII {
	/**
     * @param str: A string
     * @return An integer
     */
	public int atoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		int cur = 0;
		boolean isPositive = true;
		if (str.charAt(cur) == '+') {
			cur++;
		} else if (str.charAt(cur) == '-') {
			cur++;
			isPositive = false;
		}
		double result = 0;
		while (cur < str.length()) {
			char temp = str.charAt(cur);
			if (temp > '9' || temp < '0') {
				break;
			}
			result = result * 10 + (temp - '0');
			cur++;
		}

		if (!isPositive) {
			if (result < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			return (int) (-result);
		}
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) result;
	}
}
