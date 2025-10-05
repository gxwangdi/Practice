import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	/**
	 * @param nums: A list of integers
	 * @return an integer
	 */
	public int longestConsecutive(int[] num) {
		int max = 0;
		if (num == null || num.length == 0) {
			return max;
		}

		Set<Integer> set = new HashSet<>();
		for (int i : num) {
			set.add(i);
		}

		for (int i : num) {
			if (!set.contains(i)) {
				continue;
			}
			int count = 1;
			set.remove(i);
			int lower = i - 1;
			while (set.contains(lower)) {
				set.remove(lower);
				lower--;
				count++;
			}

			int upper = i + 1;
			while (set.contains(upper)) {
				set.remove(upper);
				upper++;
				count++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
