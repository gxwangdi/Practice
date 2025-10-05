


class GuessGame {
	/**
	 * @param num my guess, ranges from 1~n.
	 * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	 * */
	int guess(final int num) {
		return -1;
	}
}

public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            }
            if (result == -1) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (guess(start) == 0) {
            return start;
        }
        if (guess(end) == 0) {
            return end;
        }
        return -1;
    }
}




