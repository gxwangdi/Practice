
In binary, power of 2 is like 1 00000....00.   Change to binary in string, and remove all 0s, it should be 1.
Space O(n in bits) Time O(n in bits)  It needs to deal with every bit in binary
string representation one by one.

Divide by 2, until it is odd, then it should be 1.  
Space O(1), Time O(logn).  
