
public class PowXN {
	/**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

	private double power(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double v = power(x, n / 2);
		v = v * v;
		if (n % 2 == 1) {
			v = v * x;
		}
		return v;
	}
}
