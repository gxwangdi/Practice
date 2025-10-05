import java.util.ArrayList;
import java.util.Arrays;


public class ThreeSum {
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (numbers == null || numbers.length == 0) {
			return res;
		}
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 2; i++) {
			int j = i + 1;
			int k = numbers.length - 1;
			while (j < k) {
				int sum = numbers[j] + numbers[k];
				if (sum < -numbers[i]) {
					j++;
					continue;
				}
				if (sum > -numbers[i]) {
					k--;
					continue;
				}
				ArrayList<Integer> list = new ArrayList<>();
				list.add(numbers[i]);
				list.add(numbers[j]);
				list.add(numbers[k]);
				if (!res.contains(list)) {
					res.add(list);
				}
				j++;
				k--;
			}
		}
		return res;
	}
}
