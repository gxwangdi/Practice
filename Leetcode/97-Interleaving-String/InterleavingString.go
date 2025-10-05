func isInterleave(s1 string, s2 string, s3 string) bool {
	if len(s3) != len(s1)+len(s2) {
		return false
	}
	m := len(s1)
	n := len(s2)
	//     dp[m+1][n+1]
	dp := make([][]bool, m+1)
	for i := range dp {
		dp[i] = make([]bool, n+1)
		for j := range dp[i] {
			dp[i][j] = false
		}
	}
	dp[0][0] = true
	for i := 1; i < m+1; i++ {
		dp[i][0] = s1[i-1] == s3[i-1] && dp[i-1][0]
	}
	for j := 1; j < n+1; j++ {
		dp[0][j] = s2[j-1] == s3[j-1] && dp[0][j-1]
	}
	for i := 1; i < m+1; i++ {
		for j := 1; j < n+1; j++ {
			dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) || (dp[i][j-1] && s2[j-1] == s3[i+j-1])
		}
	}
	return dp[m][n]
}
