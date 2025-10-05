
This is obvious bit operation.

For every bit in the result int, 
1. 1+0=1， 0+1=1， 0+0 = 1+1 = 0. so a^b to get the result. 
2. For carry, only when 1+1, so (a&b)<<1 to get all the carries from all bits.


