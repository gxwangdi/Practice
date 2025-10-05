import java.util.Arrays;


public class ThreeSumClosest {
	/**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
	public int threeSumClosest(int[] numbers, int target) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		if (numbers == null || numbers.length < 3) {
			return res;
		}
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 2; i++) {
			int j = i + 1;
			int k = numbers.length - 1;
			while (j < k) {
				long sum = numbers[i] + numbers[j] + numbers[k];
				if (sum == target) {
					return (int) sum;
				}
				if (Math.abs(sum - target) < min) {
					min = (int) Math.abs(sum - target);
					res = (int) sum;
				}

				if (sum > target) {
					k--;
				} else {
					j++;
				}
			}
		}
		return res;
	}
}
