class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        bool dp[m+1][n+1]={{false}};
        dp[0][0] = true;
        for(int i=1; i<m+1; i++) {
            dp[i][0] = (s1.at(i-1) == s3.at(i-1)) && dp[i-1][0];
        }
        for(int j=1; j<n+1; j++) {
            dp[0][j] = (s2.at(j-1) == s3.at(j-1)) && dp[0][j-1];
        }
        for(int i=1; i<m+1; i++) {
            for (int j=1; j<n+1; j++) {
                dp[i][j] = (dp[i-1][j] && s1.at(i-1) == s3.at(i+j-1)) || (dp[i][j-1] && s2.at(j-1) == s3.at(i+j-1));
            }
        }
        return dp[m][n];
    }
};


