
dp[i](j) means the minimum cost of ith number adjusted to j. 
For each dp[i](j), minimum cost = minimum cost dp[i-1](j-target.....j+target) + abs(A[i]-j)

So three loop iteration:
i, j, [j-target....j+target].

