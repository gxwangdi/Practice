
Well,  a naive dp solution would be O(n^2) time O(n^2) space.       

dp[n][m] = arr[n][m] + dp[n-1][m] + dp[n][m-1] - dp[n-1][m-1].    
================================================

Found a solution here that I do not quite understand: 
https://discuss.leetcode.com/topic/53939/java-117ms-beat-99-81-merge-sort    
/*
 * If # of columns is smaller, process one set of columns [i..j) at a time, for each different i<j.
 * For one set of colums [i..j), do it like "Count of Range Sum".
 * O(n) = n^2 * mlogm.
 * Assume we have such result.
 */



