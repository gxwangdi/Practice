

class Minimumdifferencebetweenhighestandlowestofkscores {
    public int minimumDifference(int[] nums, int k) {
        if (k==1 || nums.length <k) {
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[k-1] - nums[0];
        for (int i=1; i + k <= nums.length; i++) {
            int temp = nums[i+k-1] - nums[i];
            min = Math.min(min, temp);
        }
        return min;
    }
}
