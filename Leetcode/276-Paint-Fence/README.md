
Define dp[i] as the possible cases for n posts.

dp[0] = 1;
dp[1] = k;
dp[2] = k*k;

dp[i] = (k-1)dp[i-1] + (k-1)dp[i-2];   
// The color on ith post can not be the same as (i-1)th post, and can not be the same as (i-2)th post.   
// This could be pretty clear if drawing the tree structure. 

answer:  dp[n].  

Space O(n), Time O(n);  

After the %3 optimization, Space become O(1).  

