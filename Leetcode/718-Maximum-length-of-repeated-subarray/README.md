
# DP Approach:

A common subarray of A and B must start at some A[i] and B[j], let dp[i][j] be the longest common prefix of A[i:] and B[j:]. Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1. Also, the answer is max(dp[i][j]) over all i, j.

The challenge here, is to define dp[i][j] and based on the definition, the population order. It should be a bottom-up dynamic programming to find the answer based on this recurrence. Our loop invariant is that the answer is already calculated correctly and stored in dp for any larger i, j.    

DP normally takes the same time and space complexity as it simply populates every intermediate result.
Time O(len(A) * len(B)),
Space O(len(A) * len(B))


# Sliding Array Approach

Intuitively, the algorithm slides one array over the other and for each sliding position compute the max length of repeated subarray within the overlapping window.   
// The initial position and the directions in which we slide. One step means shifting the top array by one position (index) to the right, or the the bottom array by one position (index) to the left:
        //          [1,2,3,2,1]   -->
        //           <--    [3,2,1,4,7]  

        //          [1,2,3,2,1]    
        //                [3,2,1,4,7]  

        //               a
        //          [1,2,3,2,1]      -->
        //     <--      [3,2,1,4,7]  
        //               b
        // until                 [1,2,3,2,1]      -->
        //      <--      [3,2,1,4,7]


This is easy to make mistakes, suggest to reference the diagram while coding.
Time O((M+N) * min(M,N))
Space O(1);
