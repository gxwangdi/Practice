
Firstly sort it in ascending order,  based on start and end.   

Take the first interval as pivot, and compare with next one.
If pivot.end < next.start,  put pivot into result set, and assign next to pivot,
Else   merge next into pivot. 

After the loop, put pivot into result set.  

Space O(n)    Time O(nlogn)   

