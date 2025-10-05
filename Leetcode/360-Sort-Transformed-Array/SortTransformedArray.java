public class SortTransformedArray {
    
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            nums[i] = getTransform(a, b, c, nums[i]);
        }
        // Arrays.sort(res); // This takes O(nlogn)   
        int index = a>0?nums.length-1:0;
        int i=0;
        int j=nums.length-1;
        while (i <= j) {
            if (a>0) {
                if (nums[i]>nums[j]) {
                    res[index] = nums[i];
                    i++;
                } else {
                    res[index] = nums[j];
                    j--;
                }
                index--;
            } else {
                if (nums[i]<nums[j]) {
                    res[index] = nums[i];
                    i++;
                } else {
                    res[index] = nums[j];
                    j--;
                }
                index++;
            }
        }
        return res;
    }
    
    private int getTransform(int a, int b, int c, int x) {
        return a*x*x + b*x + c;
    }
}





