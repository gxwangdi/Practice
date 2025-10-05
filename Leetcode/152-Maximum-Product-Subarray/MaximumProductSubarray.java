public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxProduct = nums[0];
        int maxTemp = nums[0];
        int minTemp = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            int a = maxTemp*nums[i];
            int b = minTemp*nums[i];
            maxTemp = Math.max(Math.max(a,b), nums[i]);
            minTemp = Math.min(Math.min(a,b), nums[i]);
            maxProduct = Math.max(maxProduct, maxTemp);
        }
        return maxProduct; 
    }
}



