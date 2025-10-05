
C[i, k] = A[i, j] * B[j, k];      

So for A, create a map<j, <A, i>>,  for B, create a map<j, <B, k>>,   
and scan all keyEntry in map A, and see if there is an entry in B. 

The preprocessing still takes Time O(Max(A.size(), B.size())) 

