import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstMissingPrimeNumber {
	/*
	 * @param : an array of integer
	 * 
	 * @return: the first missing prime number
	 */
	public int firstMissingPrime(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 2;
		}
		Set<Integer> input = new HashSet<>();
		int max = nums[0];
		for (Integer i : nums) {
			input.add(i);
			max = Math.max(max, i);
		}
		boolean[] isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < isPrime.length; i++) {
			if (!isPrime[i]) {
				continue;
			}
			if (!input.contains(i)) {
				return i;
			}
			primes.add(i);
			int p = i + i;
			while (p < isPrime.length) {
				isPrime[p] = false;
				p += i;
			}
		}
		// the smallest missing prime not in given range.
		int candidate = max + 1;
		while (true) {
			if (isPrime(primes, candidate)) {
				return candidate;
			}
			candidate++;
		}
	}

	private boolean isPrime(List<Integer> primes, int cand) {
		for (Integer i : primes) {
			if (cand % i == 0) {
				return false;
			}
		}
		return true;
	}
}
