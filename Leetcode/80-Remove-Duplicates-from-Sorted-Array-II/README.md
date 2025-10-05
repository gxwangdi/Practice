
For single duplicate, once we find duplicates, ignore it.  
Pay attention: 
1. res = 0, cur = 1;
2. compare cur and cur-1, cur = 1,...length-1     
3. count should be init as 1, not 2,  test your code with [1,1,1,2] and [1,2,2,2].  

Now we can use a boolean isDuplicate, init as false;
if arr[cur] != arr[cur+1],   isDuplicate = false,  and write it into result set. 
if arr[cur]==arr[cur+1], 
     if (!isDuplicate)    isDuplicate = true; write it into result set,
     else ignore it.     

Space O(1), Time O(n).   
