
This is like binary search.    First of all need to check if 1 is good.  If 1 is good, then something bad in the middle.   

For  start...end  range,       
if (start+end)/2 is good, search (start+end)/2....end range;
if (start+end)/2 is bad, check (start+end)/2-1, good, then return (start+end)/2;
or else search start...(start+end)/2 range.    

Space O(1),   Time O(logn)    

