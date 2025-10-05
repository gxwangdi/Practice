https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/discuss/1677019/JavaPython-3-Two-codes-w-brief-analysis      

HashSet Approach.
Check Duplicate based on input range
n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n

n numbers put into n slots, if there is any duplicate, then there must be some number missing.

BitSet approach.
BitSet is a space improvement based on check duplicate.
Note that 1 <= n <= 100, we can not use bit ops to merge result of one row/column in one integer or long.  Otherwise integer and long comparison only takes 1 cycle.
