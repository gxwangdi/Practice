public class DecodeWays {
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length()+1];
        nums[0] = 1;
        nums[1] = s.charAt(0)!='0'?1:0;
        for (int i = 2; i <= s.length(); i++) {
            // Take itself as one way.
            if (s.charAt(i-1)!='0') {
                nums[i] = nums[i-1];
            }
            
            // If there is one more possibility that combine the two. 
            // PAY ATTENTION to how int[] nums = new int[s.length()+1]; works here.
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[s.length()];
    }
    
    
    
    
    /*   // My dp does not work....
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i=1; i<s.length(); i++) {
            int times = 1;
            if (s.charAt(i-1) < '3' && s.charAt(i) < '7') {
                times++;
            }
            dp[i] = times * dp[i-1]-1;
        }
        return dp[s.length()-1];
    }
    */
}





