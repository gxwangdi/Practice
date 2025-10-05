https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time  

Use buckets to record the last position of digit 0 ~ 9 in this num.

Loop through the num array from left to right. For each position, we check whether there exists a larger digit in this num (start from 9 to current digit). We also need to make sure the position of this larger digit is behind the current one. If we find it, simply swap these two digits and return the result.
