public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int lastv = 0;
        int maxLen = 1;
        for (int i=1; i<len; i++) {
            int diff = nums[i] - nums[i-1];
            if (lastv * diff < 0) {
                maxLen++;
            }
            if (lastv ==0 && diff!=0) {
                maxLen = 2;
            }
            if (diff != 0) {
                lastv = diff;
            }
        }
        return maxLen;
    }// end of wiggleMaxLength    
}









