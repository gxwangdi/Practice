public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int n = s.length();
        boolean[][] IP = getIsPalindrome(s);
        
        int[] dp = new int[n+1]; 
        for (int i=1; i<=n; i++) {
            dp[i] = i;
            for (int j=0; j<i; j++) {
                if (!IP[j][i-1]) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        return dp[n]-1;
    }
    
    private boolean[][] getIsPalindrome(String s) {
        
        int n = s.length();
        boolean[][] IP = new boolean[n][n];  
        
        for (int i=0; i<n; i++) {
            IP[i][i] = true;
        }
        for (int i=0; i+1<n; i++) {
            IP[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }
        
        for (int len = 2; len<n; len++) {
            for (int start = 0; start + len<n; start++) {
                IP[start][start+len] = 
                    IP[start+1][start+len-1] && (s.charAt(start) == s.charAt(start+len));
            }
        }
        return IP;
    }// end of getIsPalindrome     
}





