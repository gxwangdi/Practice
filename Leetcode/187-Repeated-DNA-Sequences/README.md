
10 chars sliding window moves forward, prepare a set to store all these, and when a duplicate happens, then put it into result set. 

We still need a set for the result set initially, as there might be duplicates for the result.  

Space O(n), Time O(n^2) as the substring would introduce another O(n) complexity.  

   

