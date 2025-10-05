import java.util.Arrays;



public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        
        Arrays.sort(nums); 
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }// end of containsDuplicate   
}


