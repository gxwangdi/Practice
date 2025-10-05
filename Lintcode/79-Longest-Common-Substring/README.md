
Brute force would be:
get all substrings in A, O(n2)
get all substrings in B, O(n2)
compare all possible pair in above two group, O(n4)

While jiuzhang officailly gave an improved brute force solution O(n3).

Dynamic programming is like:

If char i in A != char j in B
then dp[i, j] == 0;
else 
dp[i, j] = dp[i-1, j-1] + 1;

Space O(n2) Time O(n2)
