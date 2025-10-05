
Note duplicate elements, then you will need to take care of the boundary, like for case:
[0,0,0,0,0]
[-3,22,35,56,76]
22   

This one looks trivial but easy to get wrong, and my implementation is just too long and complicated !  Basically two pointer is used when we would like to remove duplicate check, but here duplicate counts ! ! !  So need to compare, and find if we can figure out something to remove duplicate check when duplicate elements exist.  

reference a priority queue solution:
https://discuss.leetcode.com/topic/50885/simple-java-o-klogk-solution-with-explanation/2       
 


Brute force manner would be, to prepare a maxHeap, and maintain size k, and scan all possible pairs.   If arrA.length * arrB.length <=k, then brute force to take every single pair. 

Two pointers, i points to pos in arrA,  j points to pos in arrB.     
Take <i, j> into result set.  

if (A[i] + B[j+1] > A[i+1] + B[j])   i++;
else j++;  

Space O(k), Time O(k).   





 