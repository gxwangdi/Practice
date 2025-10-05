
public class TrailingZeros {
	/*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
	public long trailingZeros(long n) {
		long sum = 0;
		if (n < 4) {
			return sum;
		}
		while (n != 0) {
			sum += n / 5;
			n = n / 5;
		}
		return sum;
	}
}
