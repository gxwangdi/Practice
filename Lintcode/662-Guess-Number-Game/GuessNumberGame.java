class GuessGame {
	// @param num, your guess
	// @return -1 if my number is lower, 1 if my number is higher, otherwise
	// return 0
	// int guess(int num);
	int guess(final int num) {
		// some trivial implementation.
		return 0;
	}
}

public class GuessNumberGame extends GuessGame {
	/**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        int lower = 1;
        int upper = n;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            int res = guess(mid);
            switch (res) {
                case -1:
                    upper = mid - 1;
                    break;
                case 1:
                    lower = mid + 1;
                    break;
                default:
                    return mid;
            }
        }
        if (guess(lower) == 0) {
            return lower;
        }
        return upper;
    }
}
