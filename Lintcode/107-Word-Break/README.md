
The first idea is to use dfs. memory/time limit exceeds.

dp approach:
boolean dp[n+1]. dp[i] means if s.substring(0,i) can break.
dp[0] = true;
dp[i] = OR {dp[j]}, where j<i AND s.substring(j, i) is a word. 
the answer is dp[n].

This solution is still TLE. Reference jiuzhang, it fetches a maxWordLength from the dict.

