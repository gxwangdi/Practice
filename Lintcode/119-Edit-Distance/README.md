
dp[i](j) means at least how many changes are needed to change word1s first i chars to word2s first j chars.

Init : dp[0](j) = j, dp[i](0) = i; means delete j, i chars respectively.

Function:
dp[i][j] = dp[i-1](j-1), if word1[i-1] == word2[j-1], means no more changes needed.

dp[i][j] = 1 + MIN( dp[i-1][j-1], dp[i-1][j], dp[i](j-1) ). if word1[i-1] != word2[j-1].
Take dp[i-1](j-1) means to replace a char in either word1 or word2;
Take dp[i-1](j) means to replace a char in word1;
take dp[i](j-1) means to replace a char in word2;

Answer: dp[m](n).

