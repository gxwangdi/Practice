

We need to use two dp arrays.

One dp is used to determine if a substring from i...j is a palindrome. 
IP[i][j].

Init: IP[i][i] = true;
Function: IP[i][j] = IP[i-1][j+1] && s[i]==s[j];

One dp array is used to determine the substring for the first i chars can have at least how many palindromes.
Init: dp[i] = i;
Function: dp[i] = MIN(dp[j] + 1), j<i && IP[j+1][i] ;
Answer: dp[n] - 1. // Pay attention, n-1 cuts to split n segments    


