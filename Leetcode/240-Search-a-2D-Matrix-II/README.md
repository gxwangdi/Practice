
This is really, really binary search after binary search.    

1. BSearch first column, get the lowest position that matrix[i][0] <target;   
2. In rows j = 0~i, get the lowest position that matrix[j][matrix[j].length-1]<target;
3. for rows k = (j+1)~i, do binary search for target.   

Space O(1)   Time O(logmlogn)     
====================

Search online and find a simple implementation, which has O(m+n) solution. 

Starting from the top right corner, and compare target and matrix[i][j], 
if matrix[i][j] < target, then the row does not have target, i++;
if matrix[i][j] > target, then the column does not have target, j--;
If it goes outside the boundary, then matrix does not contain target, return false;
  