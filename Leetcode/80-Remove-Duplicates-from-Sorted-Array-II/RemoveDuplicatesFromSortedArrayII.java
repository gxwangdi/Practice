public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        
        int res = 0;
        int cur = 1;
        int count = 1;
        while (cur < nums.length) {
            if (nums[cur] != nums[cur-1]) {
                count = 1;
                nums[++res] = nums[cur];
            } else {
                if (count>0) {
                    count--;
                    nums[++res] = nums[cur];
                }
            }
            cur++;
        }
        return res+1;
    }// end of remvoeDuplicate
}



