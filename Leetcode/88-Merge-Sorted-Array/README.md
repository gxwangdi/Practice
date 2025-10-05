
Initially this looks like insertion sort, take elements in numB and insert into numA, will need to move all afterwards elements in numA before inserting, which introduce O(n2).  

How to remove the process of moving afterwards elements before inserting something?     Find B`s first element`s position in A, and move all A`s elements after the position to the tail in a one time manner, and merge.    

Or, just simply merge A and B from the tail.   

Space O(1) Time O(n)    

  