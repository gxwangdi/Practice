import java.util.ArrayList;


public class MajorityNumberII {
	/**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
	public int majorityNumber(ArrayList<Integer> nums) {
		int number1 = Integer.MIN_VALUE;
		if (nums == null || nums.size() == 0) {
			return number1;
		}
		if (nums.size() < 3) {
			return nums.get(0);
		}
		int count1 = 0;
		int number2 = Integer.MIN_VALUE;
		int count2 = 0;

		for (Integer i : nums) {
			if (number1 == i) {
				count1++;
			} else if (number2 == i) {
				count2++;
			} else if (count1 == 0) {
				number1 = i;
				count1 = 1;
			} else if (count2 == 0) {
				number2 = i;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		count1 = count2 = 0;
		for (Integer i : nums) {
			if (number1 == i) {
				count1++;
			}
			if (number2 == i) {
				count2++;
			}
		}
		if (count1 > nums.size() / 3) {
			return number1;
		}
		return number2;
	}
}
