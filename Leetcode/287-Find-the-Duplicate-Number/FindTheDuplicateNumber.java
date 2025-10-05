public class FindTheDuplicateNumber {
    private int numBelow(int[] nums, int target) {
        int res = 0;
        for (int i : nums) {
            if (i<=target) {
                res++;
            }
        }
        return res;
    }
    // O(nlogn) solution
    public int findDuplicate(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left < right){
            int mid=left+(right-left)/2;
            int count=numBelow(nums, mid);
            if(count>mid) right=mid;
            else left=mid+1;
        }
        return right;
    }
    /* // O(n) solution from online.
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length ==0) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }*/
}
