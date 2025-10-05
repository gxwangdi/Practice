

public class RotatedArray {
    
    public void rotate(int[] nums, int k) {
        if (nums == null || k<=0 || nums.length<=0 || k== nums.length) {
            return;
        }
        if (k>nums.length) {
            k = k % nums.length;
        }
        int a = nums.length - k;
        reverse(nums, 0, a-1);
        reverse(nums, a, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        if (nums == null || nums.length == 1)
            return;
        
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
    /*
    public void rotate(int[] nums, int k) {
        if (nums == null || k<=0 || nums.length<=0 || k== nums.length) {
            return;
        }
        if (k>nums.length) {
            k = k % nums.length;
        }
        int[] rotate = new int[k];
        for (int i=0, j=nums.length-k; j<nums.length; i++, j++) {
            rotate[i] = nums[j];
        }
        
        for (int i=nums.length-(k+1), j=1; i>=0; i--, j++) {
            nums[nums.length-j] = nums[i];
        }
        
        for (int i=0; i<k; i++) {
            nums[i] = rotate[i];
        }
    }//end of rotate 
    */
}


