
We can calculate how much water a cell can hold, by

W[i] = min(left[i], right[i]) - heights[i],

Of which left[i] means from left to i the highest bar, right[i] means from right to i the highest bar.

So we need to build two arrays, left[i] and right[i].

Space O(n), Time O(n)

