
If the array can be divided into two subsets, of which sum are equal, then the total sum of the array must be even.

Then the problem becomes find if there exists a subarray that sum = totalSum/2.

This is pretty much like a knapsack problem. For each number, we can pick it or not. A normal ways is like DFS.

For dp solution, let us assume dp[i)[j) means whether the specific sum j can be gotten from the first i numbers. If we can pick such a series of numbers from 0-i whose sum is j, dp[i)[j) is true, otherwise it is false.

Base case: dp[0)[0) is true; (zero number consists of sum 0 is true)

Transition function: For each number, if we don't pick it, dp[i][j) = dp[i-1)[j), which means if the first i-1 elements has made it to j, dp[i)[j) would also make it to j (we can just ignore nums[i)). If we pick nums[i). dp[i)[j) = dp[i-1)[j-nums[i)), which represents that j is composed of the current value nums[i) and the remaining composed of other previous numbers. Thus, the transition function is dp[i)[j) = dp[i-1)[j) || dp[i-1)[j-nums[i))

Given solution is a simplified one dimentional array dp.

Note that it say "Each of the array element will not exceed 100.
The array size will not exceed 200.", it gives us an option to use bit set or hardcode the upper size of a solution. That will generate the most efficient solution.