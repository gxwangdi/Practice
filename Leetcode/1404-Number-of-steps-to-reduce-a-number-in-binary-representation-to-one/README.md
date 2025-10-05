
The lower bound of this problem is O(n).  There is no easier way to deal with things in cluster, like scan and count 1s cluster.

We only need to think of these two:
what it current bit is '0'? 1 op
what if current bit is '1'? 2 op, 1 op to add 1 and the other to remove the resulting 0 at the same bit, and implicating the carry.
The carry bit will go forward forever.   

Make sure to progress from right to left. 

O(n) Time O(1) Space    
