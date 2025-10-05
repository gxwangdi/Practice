public class RangeSumQueryImmutable {

    // For functions called frequently, cache something to reduce redundant computation or intermediate result. 
    private int[] mNums;
    
    private long[] mSum;
    // Assuming nums is always valid. 
    public RangeSumQueryImmutable(int[] nums) {
        mNums = nums;
        if (nums != null) {
            mSum = new long[nums.length];
        }
        
        if (nums.length > 0) {
            mSum[0] = nums[0];
            for (int i=1; i<mSum.length; i++) {
                mSum[i] = mSum[i-1] + nums[i];
            }
        }
    }
    
    
    public int sumRange(int i, int j) {
        if (mSum == null)
            return Integer.MIN_VALUE;
        
        if (i==0)
            return (int)mSum[j];
            
        int min = Math.min(i, j);
        int max = Math.max(i, j);      
        if (min < 0) {
            min = 0;
        }
        if (max > mNums.length-1) {
            max = mNums.length-1;
        }
        return (int)(mSum[max] - mSum[min-1]);
    }

    /*
    private int[] mNums = null;
    public NumArray(int[] nums) {
        if ( nums!=null && nums.length > 0) {
            mNums = nums;
        }
    }

    public int sumRange(int i, int j) {
        if (mNums == null) {
            return Integer.MIN_VALUE;
        }
        int min = Math.min(i, j);
        int max = Math.max(i, j);      
        if (min < 0) {
            min = 0;
        }
        if (max > mNums.length-1) {
            max = mNums.length-1;
        }
        
        int result = mNums[min];
        int iter = min + 1;
        while (iter<=max) {
            result += mNums[iter];
            iter ++;
        }
        return result;
    }// end of sumRange   
    */
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);



