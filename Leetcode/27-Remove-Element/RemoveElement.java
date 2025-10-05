public class RemoveElement {
    
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i=0; 
        int j=0;
        while (j<nums.length) {
            if (nums[j]!=val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
    
    /*
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0]==val?0:1;
        }
        
        int times = 0;
        int i = 0;
        int j = nums.length-1;
        while (i<j) {
            while (nums[i]!=val && i<j)
                i++;
            while (nums[j]==val && i<j) {
                times++;
                j--;
            }
                
            if (i==j) {
                if (nums[i]== val)
                    times++;
                break;
            }
                
            times ++;
            swap(nums, i, j);
            i++;
            j--;
        }
        return nums.length-times;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/
}