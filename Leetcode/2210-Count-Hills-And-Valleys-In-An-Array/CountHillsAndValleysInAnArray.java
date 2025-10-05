
class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        int count = 0;
        if (nums == null || nums.length < 3) {
            return count;
        }
        int prev = nums[0];
        int cur = 0;
        int index = 1;
        // find the first non-equal element
        while (index < nums.length-1) {
            if (nums[index] != prev) {
                cur = nums[index];
                break;
            }
            index++;
        }
        boolean isHill = prev < cur;
        for (int i = index+1; i<nums.length; i++) {
            if (nums[i] == cur) {
                continue;
            }
            if (isHill) {
                if (nums[i] < cur) {
                    count ++;
                    isHill = false;
                }
                cur = nums[i];
            } else {
                if (nums[i] > cur) {
                    count ++;
                    isHill = true;
                }
                cur = nums[i];
            }
        }
        return count;
    }
}
