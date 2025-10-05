
Basically BFS, scan the whole 2D matrix. count init as 0.

When encountering 1, put it into a queue, and count++. search all adjacent point, if it is 1, change it to 0.

return count.

Space O(mn) Time O(mn).

Solution 2 would be Union Find, not familiar with that for now.

Pay attention to the input, it is a boolean array, not a int array. Need to talk with interviewer before coding!

