import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;
        if (nums == null || nums.length<3) {
            return sum;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - temp) < min) {
                    min = Math.abs(target - temp);
                    sum = temp;
                }
                if (min == 0) {
                    return sum;
                }
                if (temp < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}