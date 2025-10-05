
First of all, the input array is unsorted, and it has requirements on original index.     

Use sliding window, with size k.   `cause abs(i - j) <= k;

Secondly, abs(A[i] - A[j]) <= t, then we will need to use ceiling() or floor() in O(logk).  so think of  TreeSet.    

Space O(k),    Time O(nlogk)   k== O(n).  
＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

Found a solution here:
https://discuss.leetcode.com/topic/27608/java-python-one-pass-solution-o-n-time-o-n-space-using-buckets     

The idea is like the bucket sort algorithm. Suppose we have consecutive buckets covering the range of nums with each bucket a width of (t+1). If there are two item with difference <= t, one of the two will happen:

(1) the two in the same bucket
(2) the two in neighbor buckets


