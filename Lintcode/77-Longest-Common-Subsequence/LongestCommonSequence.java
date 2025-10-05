
public class LongestCommonSequence {
	/**
	 * @param A, B: Two strings.
	 * @return: The length of longest common subsequence of A and B.
	 */
	public int longestCommonSubsequence(String A, String B) {
		if (A == null || B == null || A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int m = A.length();
		int n = B.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		return dp[m][n];
	}
    
    /*
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int max = 0; 
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return max;
        }
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) {
            char ci = A.charAt(i);
            for (int j=0; j<n; j++) {
                char cj = B.charAt(j);
                if (ci != cj) {
                    dp[i][j] = 0;
                    continue;
                } 
                
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                int maxSum = 0;
                for (int x = i-1; x>=0; x--) {
                    for (int y = j-1; y>=0; y--) {
                        maxSum = Math.max(maxSum, dp[x][y]);
                    }
                }
                dp[i][j] = maxSum +1;
                max = Math.max(max, dp[i][j]);
            }// j loop
        }// i loop
        return max;
    }
    */
}
