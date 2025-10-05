Fall into DFS -> memoized DFS -> DP track. Can not figure out binary search solution. 

Binary Search
Intuition

This approach is quite different from the previous approaches. The characteristics of this problem are a good fit for the dynamic programming solution hence, it's easy to overlook the idea of using binary search. This problem satisfies the property that we can guess the answer (the minimum largest sum subarray value) and check if that value was too high or too low, thus narrowing our search space. It requires a different perspective to think of this approach, but after realizing that this problem is a candidate for a binary search solution, it becomes easier to implement than the previous approaches.

The goal of this problem is to find the minimum largest subarray sum with mm subarrays. Instead of finding the answer directly, what if we try to guess the answer (say XX), and check whether this particular value could be the largest subarray sum with mm subarrays. If this is possible, we can check all values for X \geq 0X≥0, and the first value that satisfies the condition will be the answer. Thus, by repeatedly solving the following problem, we can find the minimum largest subarray sum needed to split nums into mm subarrays:

Given an array of nn integers and a value XX, determine the minimum number of subarrays the array needs to be divided into such that no subarray sum is greater than XX.

If the minimum number of subarrays required is less than or equal to mm then the value XX could be the largest subarray sum.

The solution to this newly defined problem is as follows

First, make sure XX is greater than or equal to the maximum element in the array. Otherwise, no solution would be possible because we cannot divide an element.
Start from 0th index and keep adding elements to sum only if adding the element does not make sum greater than XX.
If adding the current element would make the sum greater than XX then we have to split the subarray here. So we will increment the number of splits required (splitsRequired) and set sum to the value of current element (signifying that the current subarray only contains the current element).
Once we traversed the whole array, return splitsRequired + 1. This is the minimum number of subarrays required.
Now the problem with the current solution is that the value of XX can be as large as the sum of integers in the given array. Hence, checking for all values of XX is not feasible.

The key observation here is that if we are able to split the array into mm or fewer subarrays for a value XX then we will also be able to do it for any value greater than XX. This is because the number of subarrays would be even less in case of any value greater than XX. Similarly, if it's not possible for a value XX it will not be possible to have mm or fewer splits for any value less than XX.

Therefore, instead of searching linearly for XX, we can do a binary search! If we can split the array into mm or fewer subarrays all with a sum that is less than or equal to XX then we will try a smaller value for XX otherwise we will try a larger value for XX. Each time we will select XX so that we reduce the size of the search space by half.

Algorithm

Store the sum of elements in nums in the variable sum and the maximum element of the array in maxElement.

Initialize the boundary for binary search. The minimum value for the largest subarray sum is maxElement and the maximum value is equal to sum. Hence assign left and right to maxElement and sum respectively.

Then while the left is not greater than right:

a. Find the mid-value in range [left, right], this is equal to the maximum subarray sum allowed. Store it in maxSumAllowed.

b. Find the minimum number of subarrays required to have the largest subarray sum equal to maxSumAllowed.

If the number of subarrays is less than or equal to mm then assign maxSumAllowed as the answer minimumLargestSplitSum and decrease the value of our right boundary.
If the number of subarrays is more than mm this can't be the answer hence, increase the value of our left boundary.
Return minimumLargestSplitSum.

Complexity Analysis

Here NN is the length of the array and SS is the sum of integers in the array.

Time complexity: O(N \cdot \log(S))O(N⋅log(S))

The total number of iterations in the binary search is \log(S)log(S), and for each such iteration, we call minimumSubarraysRequired which takes O(N)O(N) time. Hence, the time complexity is equal to O(N \cdot \log(S))O(N⋅log(S)).

Space complexity: O(1)O(1)

We do not use any data structures that require more than constant extra space.
