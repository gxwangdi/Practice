
Most straightforward approach is to reuse the solution in next permutation. Given initial [1,2, 3, 4...n], run nextPermutation() for k-1 times, and return.

Think of these, full permutation for i digits is (i-1)!, so if k locates in (i-1)! and (i+1 -1)!, then we can ignore a lot of computation.

Actually k/(n-1)! indicates the index of current number, and k%(n-1)! denotes remaining index for the remaining n-1 numbers. As this process goes on, we can get the kth permutation directly.

