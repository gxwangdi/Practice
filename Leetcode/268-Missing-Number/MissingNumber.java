public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            res = res ^ nums[i] ^ (i+1);
        }
        return res;
    }
}
