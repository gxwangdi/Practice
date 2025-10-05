
match it in recursive manner, that is easier to implement.  

if both s and p reach the end at the same time,  return true;

if either one reaches the end, return false;

if i == j or j == '?',  check (s, i+1,  p, j+1)  

if j == '*',  check (s, i+1, p, j+1) || (s, i+1, p, j)  

else  return false;
=================================TLE      

DP solution,   Space O(mn)  Time O(mn).   
dp[i][j] means s[0...i-1] matches p[0...j-1].   
init: 
dp[0][0] = true,  dp[0][j] = true before first '*',  dp[i][0] = false for [1...s.length].  
transition:
if p(j) == '*', dp[i][j] = dp[i-1][j] || dp[i][j-1].   // we count star or we do not count star. 
else   dp[i][j] = dp[i-1][j-1] && (s[i-1] == p[j-1] || p[j-1] == '?' )     

answer: dp[m][n].     

 

