
It is easy to iterate from brute force to dynamic programming.

This is a GOOD tutorial how to use two linear struct to downgrade 2-d struct to 1-d struct, and decrease the complexity.

Linear Complexity:
Follow the explanation in 907. Sum of Subarray Minimums

Intuition
res = sum(A[i] * f(i))
where f(i) is the number of subarrays,
in which A[i] is the minimum.

To get f(i), we need to find out:
left[i], the length of strict bigger numbers on the left of A[i],
right[i], the length of bigger numbers on the right of A[i].

Then,
left[i] + 1 equals to
the number of subarray ending with A[i],
and A[i] is single minimum.

right[i] + 1 equals to
the number of subarray starting with A[i],
and A[i] is the first minimum.

Finally f(i) = (left[i] + 1) * (right[i] + 1)

For [3,1,2,4] as example:
left + 1 = [1,2,1,1]
right + 1 = [1,3,2,1]
f = [1,6,2,1]
res = 3 * 1 + 1 * 6 + 2 * 2 + 4 * 1 = 17

Explanation
To calculate left[i] and right[i],
we use two increasing stacks.

Complexity
All elements will be pushed twice and popped at most twice
Time O(n)
Space O(n)
