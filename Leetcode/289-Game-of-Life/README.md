
This looks like brute force. To check one by one, and record only the cell coordinations that is about to change.     

Follow up: 
1 change to 2, and 0 change to -1, if there is any change, and refresh.   Or we can come up with solution like this:
[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 

To get the current state, simply do   board[i][j] & 1  
To get the next state, simply do   board[i][j] >> 1   

For boundary, we can use cycle, like <x%len, y%len>.    



