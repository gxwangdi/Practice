https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/discuss/478216/Java-intuitive-non-brute-force

The idea is not to list all possible elements a and b and validate one by one, instead, build a and b from n directly.

build two non zero numbers that sums n , starting from the least significant digit.
trick is to treat 0 and 1 as 10 and 11

Take care of carry and step.
