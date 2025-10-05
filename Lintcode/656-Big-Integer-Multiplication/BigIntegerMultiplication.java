public class BigIntegerMultiplication {
	/**
	 * @param num1
	 *            a non-negative integers
	 * @param num2
	 *            a non-negative integers
	 * @return return product of num1 and num2
	 */
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return null;
		}
		int n1 = num1.length();
		int n2 = num2.length();
		int[] product = new int[n1 + n2]; // Note the upper bound of the size.
		for (int i = n1 - 1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				int i1 = num1.charAt(i) - '0';
				int i2 = num2.charAt(j) - '0';
				product[i + j + 1] += i1 * i2; // Note the index.
			}
		}

		int carry = 0;
		for (int i = product.length - 1; i >= 0; i--) {
			int temp = (product[i] + carry) % 10;
			carry = (product[i] + carry) / 10;
			product[i] = temp;
		}

		StringBuilder sb = new StringBuilder();
		int cur = 0;
		while (cur < product.length && product[cur] == 0) {
			cur++;
		}
		while (cur < product.length) {
			sb.append(product[cur]);
			cur++;
		}
		if (sb.length() == 0) {
			return "0";
		}
		return sb.toString();
	}
}
