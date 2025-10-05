
public class CoinsInALine {
	/**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
	public boolean firstWillWin(int n) {
		if (n < 1) {
			return false;
		}
		return !(n % 3 == 0);
	}
}
