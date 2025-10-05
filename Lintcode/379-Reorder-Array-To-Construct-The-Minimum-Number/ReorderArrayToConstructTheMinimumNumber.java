import java.util.Arrays;
import java.util.Comparator;

public class ReorderArrayToConstructTheMinimumNumber {
	/**
	 * @param nums n non-negative integer array
	 * @return a string
	 */
	public String minNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}

		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				arr[i] = "";
				continue;
			}
			arr[i] = nums[i] + "";
		}
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String t1, String t2) {
				// This is where that matters.
				String t12 = t1 + t2;
				String t21 = t2 + t1;
				return t12.compareTo(t21);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
		}
		if (sb.length() == 0) {
			return "0";
		}
		return sb.toString();
	}// end of minNumber
}
