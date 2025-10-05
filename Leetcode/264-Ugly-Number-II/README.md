
Prepare a mini Heap, and put 1 inside.   

For each iteration, 
poll a number from the heap, and *2  *3   *5 put it back. 
Iterate k-1 times.

return the kth poll(). 
=========================================
There is a O(n) solution like:   
check the elements in result set for 2 3 and 5, and take the min as the next element in result set, pretty much like merge sort. 

Note: pay attention to cur = min+1;   
This avoids duplicate elements like 2*3 and 3*2.  

