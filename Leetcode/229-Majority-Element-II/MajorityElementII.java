import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length<3) {
            for (int i : nums) {
                if (!res.contains(i)) {
                    res.add(i);
                }
            }
            return res;
        }
        int number1 = Integer.MIN_VALUE;
        int number2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int i : nums) {
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
        
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (number1 == i) {
                count1++;
            }
            if (number2 == i) {
                count2++;
            }
        }
        if (count1 > nums.length/3) {
            res.add(number1);
        }
        if (count2 > nums.length/3) {
            res.add(number2);
        }
        return res;
    }
}



