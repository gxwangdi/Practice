class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if s1 == None or s2 == None or s3 == None or len(s3)!=len(s1) + len(s2):
            return False
        m = len(s1)
        n = len(s2)
        # dp[n+1][m+1]
        dp = [[False for i in range(n+1)] for j in range(m+1)]
        # dp = [[False] * (m+1)] * (n+1) 
        dp[0][0] = True
        for i in range(1,m+1):
            dp[i][0] = s1[i-1] == s3[i-1] and dp[i-1][0]
        
        for j in range(1, n+1):
            dp[0][j] = (s2[j-1] == s3[j-1]) and dp[0][j-1]
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                dp[i][j] = (dp[i-1][j] & (s1[i-1] == s3[i+j-1])) |(dp[i][j-1] & (s2[j-1] == s3[i+j-1]))
        
        return dp[m][n]
    
