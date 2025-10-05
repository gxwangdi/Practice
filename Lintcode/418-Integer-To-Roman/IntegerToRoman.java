public class IntegerToRoman {
	/**
	 * @param n
	 *            The integer
	 * @return Roman representation
	 */
	public String intToRoman(int n) {
		StringBuilder res = new StringBuilder();
		if (n <= 0) {
			return res.toString();
		}

		int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int digit = 0;
		while (n > 0) {
			int times = n / nums[digit];
			n -= nums[digit] * times;
			while (times > 0) {
				res.append(symbols[digit]);
				times--;
			}
			digit++;
		}
		return res.toString();
	}
}
