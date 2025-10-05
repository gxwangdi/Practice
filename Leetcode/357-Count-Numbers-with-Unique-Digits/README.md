Hint:     
A direct way is to use the backtracking approach.

Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.

This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.

Let f(k) = count of numbers with unique digits with length equals k.

f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].         
========================================
Well, I kind of understand the problem statement, but not quite understand the hint.....
 
Found an answer here in discuss:
https://discuss.leetcode.com/topic/47983/java-dp-o-1-solution

Following the hint. Let f(n) = count of number with unique digits of length n.

f(1) = 10. (0, 1, 2, 3, ...., 9)

f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij and there are 9 numbers that are different from i for j to choose from.

f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2, say ij, we can pick k to form a 3 digit number ijk and there are 8 numbers that are different from i and j for k to choose from.

Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....

...

f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1

f(11) = 0 = f(12) = f(13)....

any number with length > 10 couldn't be unique digits number.

The problem is asking for numbers from 0 to 10^n. Hence return f(1) + f(2) + .. + f(n)

There are only 11 different ans. You can create a lookup table for it. This problem is O(1) in essence.



