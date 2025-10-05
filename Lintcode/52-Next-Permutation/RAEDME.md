
Ascending order: Permutations that permutation(i) < permutation(i + 1)
Goal:
To find the next smallest permutation.
1. Find the last increasing index (a peek before decresing): k
2. Find the first bigger permutation: Well, it turns out this first bigger index is always on right side of k.
    Note: we are trying to get the least significant change on the given permuation.
    Next Step: reverse (k+1, end). This is because: before the change, right side of K will be the largest possible combination. 
    After swapping K, we need the right side to be the smallest combination. (Well, this is my understanding....
    Still a bit confused on why we take these steps in this problem)
*/

