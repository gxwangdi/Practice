
Normally, if the input is two sequences then there will be 2-D matrix for the dp array. Comparing with triangle or minimum path sum or something similar to 2-D matrix, it is just not that straight forward to figure out what dp[i](j) means and what the transition functions would be. It is easy if you can get to the points !

dp[i](j) means if s1s first i chars and s2s first j chars can build s3`s first i+j chars.

The initialization is the same as triangle!
init: dp[0](j) = (s2.charAt(j-1) == s3.charAt(j-1))
dp[i](0) = (s1.charAt(i-1) == s3.charAt(i-1))

function: dp[i](j) = (dp[i-1](j) && (s1.charAt(i-1) == s3.charAt(i+j-1)) )
||(dp[i][j-1) && (s2.charAt(j-1) == s3.charAt(i+j-1)) );

answer: dp[m][n).

Pay attention that, when initializing, index starts from 1! This is different from most other dp problems. Need to think of this in real time!

