Brute Force solution would be O(n^2), so no dp.  


Call knows(0, i) and knows(i, 0), i=1, ..., len-1;    
if ( knows(0,i) ), then remove 0, 
if ( knows(i,0) ), then remove i, remove means not adding into result set;     

and repeat this in result set until result set size does not change. If the size bigger than two or equal to 0, return -1, if it is 1, then verify the one with the whole array, and return.   

Space O(n)  Time O(nlogn)  


knows(i, j), if it is true, then i can never be celebrity, if it is false, then j can never be celebrity.    Work around this ! ! !   

Space O(1)  Time O(n)


