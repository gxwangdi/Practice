public class WildcardMatching {
    
    // Two pointer approach
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int match = 0;
        int starIdx = -1;
        while (i < s.length()) {
            // advancing both pointers
            if ( j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') ) {
                i++;
                j++;
            }
            // * found, only advancing pattern pointer
            else if (j<p.length() && p.charAt(j)=='*') {
                starIdx = j;
                match = i;
                j++;
            }
            // last pattern pointer was '*', advancing string pointer
            else if (starIdx != -1) { 
                // Note how this deals with pop stack and go to another flow. 
                j = starIdx + 1;
                match++;
                i = match;
            }
            else {
                return false;
            }
        }
        while (j<p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
    
    /*
    // DP approach
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i=1; i<=m; i++) {
            dp[i][0] = false;
        }
        for (int j=1; j<=n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (p.charAt(j-1)!='*') {
                    dp[i][j] = dp[i-1][j-1] 
                        && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?');
                } else {
                    // dp[i-1][j] means I take the '*' at pos j-1 as empty 
                    // dp[i][j-1] means I take the '*' at pos j-1 to match the char c at pos i-1. 
                    dp[i][j] = dp[i-1][j] || dp[i][j-1]; 
                }
            }
        }
        return dp[m][n];          
    }
    */
    
    
    
    /*
    // Recursive manner,  TLE
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (i < s.length() && j == p.length()) {
            return false;
        }
        if (i == s.length()) {
            String temp = p.substring(j);
            for (int cur=0; cur<temp.length(); cur++) {
                if (temp.charAt(cur) != '*') {
                    return false;
                }
            }
            return true;
        }
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);
        if (c1 == c2 || c2 == '?') {
            return isMatch(s, i+1, p, j+1);
        } else if (c2 == '*') {
            return isMatch(s, i+1, p, j) || isMatch(s, i+1, p, j+1) || isMatch(s, i, p, j+1);
        } else {
            return false;
        }
    }// end of isMatch.    
    */
}



