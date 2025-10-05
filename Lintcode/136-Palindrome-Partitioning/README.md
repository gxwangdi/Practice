
As it is asking for all possible solutions, then the time complexity is at least the size of result set.

Start from [a, a, b] as o, and add to result set. 
Proceed based on o, compare neighbouring elements to see if they are palindrome. If yes, merge them and get a new result as r, and proceed based on r.

Iterate until there is no new merges. Check duplicates like [...a,a,a,....], this will generate duplicate results.

This is the most straight forward approach.

Code is based on a dp solution. 
If pair[i][j) is true, then substring i to j is a palindrome. 
result[i], is to store from beginng until current index i (Non inclusive), all possible partitions. From the past result we can determine current result.

