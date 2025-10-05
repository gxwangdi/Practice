import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length<3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k-j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}




