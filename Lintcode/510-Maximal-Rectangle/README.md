
One approach could be to scan each cell, if current cell is 1, then find the largest possible rectangle along top left corner. Time O(n^3).

Another approach is to treat each row as a histogram, the corresponding value is the height of this row and above. We will need to get largest histogram of each row, O(n^2) time.

Get TLE, use dp to further squeeze time complexity.   

TLE on TLE_Input data.    

