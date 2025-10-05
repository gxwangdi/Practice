public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i =0;
        if (nums == null || nums.length <1) {
            return i;
        }
        
        int j = i+1;
        int cur = nums[i];
        while (j<nums.length) {
            if (nums[j] != cur) {
                i++;
                nums[i] = nums[j];
                cur = nums[i];
            } 
            j++;
        }
        return i+1;
    }
}


