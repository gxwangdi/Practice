public class PlusOne {
	/**
	 * @param digits
	 *            a number represented as an array of digits
	 * @return the result
	 */
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		if (digits[digits.length - 1] < 9) {
			digits[digits.length - 1]++;
			return digits;
		}
		int i = digits.length - 1;
		while (i >= 0 && digits[i] == 9) {
			digits[i] = 0;
			i--;
		}
		if (i >= 0) {
			digits[i]++;
			return digits;
		} else {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		}
	}
}
