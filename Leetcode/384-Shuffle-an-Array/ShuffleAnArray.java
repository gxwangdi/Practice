public class ShuffleAnArray {

    private int[] src;
    private java.util.Random rand;
    
    public ShuffleAnArray(int[] nums) {
        src = nums;
        rand = new java.util.Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return src;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = src.length;
        // int[] arr = Arrays.copyOf(src, n);
        int[] arr = src.clone();
        for (int i=n-1; i>=1; i--) {
            // int j = (int)(Math.random()*i);      
            int j = rand.nextInt(i+1);     
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
 
 
 
 
 
 
 
 