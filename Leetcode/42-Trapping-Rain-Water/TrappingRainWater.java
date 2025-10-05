public class TrappingRainWater {
    public int trap(int[] height) {
        int total = 0;
        if (height == null || height.length <3) {
            return total;
        }
        
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        int max = height[0];
        for (int i=1; i<height.length; i++) {
            left[i] = Math.max(max, height[i-1]);
            max = Math.max(max, height[i]);
        }
        
        max = height[len-1];
        for (int i=len-2; i>=0; i--) {
            right[i] = Math.max(max, height[i+1]);
            max = Math.max(max, height[i]);
        }
        
        int sum;
        for (int i=1; i<len-1; i++) {
            sum = Math.min(left[i], right[i]) - height[i];
            if ( sum > 0 ) {
                total += sum;
            }
        }
        return total;
    }
}






