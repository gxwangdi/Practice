
Basically BFS,  scan the whole 2D matrix.   count init as 0.

When encountering 1, put it into a queue, and count++.  search all adjacent point, if it is 1, change it to 0.  

return count.  

Space O(m*n) Time O(m*n).   

Solution 2 would be Union Find, not familiar with that for now.  

  

