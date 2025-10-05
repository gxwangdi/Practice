

class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];

        for(int val : nums)
        {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        max -= k;
        min += k;

        return max-min < 0 ? 0 : max-min;
    }
}
