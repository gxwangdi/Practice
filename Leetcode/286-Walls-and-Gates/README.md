
Scan the whole 2D matrix,  put coordinate into a queue. 

poll from a queue, and check if the cell has a value less than expected, do not do anything;  

If not, update the value with expected value, and put its adjacent cells into queue, with expected value node.val+1.    

