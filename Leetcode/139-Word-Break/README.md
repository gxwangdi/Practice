
The first idea is to use dfs.   memory/time limit exceeds. 

dp approach:
boolean dp[n+1]. dp[i] means if s.substring(0,i) can break.
dp[0] = true;
dp[i] = OR {dp[j]}, where j<i AND s.substring(j+1, i) is a word. 
the answer is dp[n]. 

It still gets TLE or MLE.  reference jiuzhang, dp with 3 speed up tricks could pass all the test cases.  

 



 