
This is binary search.

We will need to find an element bigger than (m+n)/2 elements, 
1. Search in A, like mid = start + (end - start)/2, 
2. Take A[mid] as target to search last index in B, B[i] <= target.
3. If i == (m+n)/2-mid+2, then it is the target. 
4. If i < (m+n)/2-mid+2, then start = mid;
5. else end = mid;

If m+n is odd, then it is looking for a single number; 
If m+n is even, then it is the ave of (m+n)/2 and (m+n)/2+1.

This is the iterative solution. jiuzhang provides an recursive approach that makes the implementation a little bit easier.
