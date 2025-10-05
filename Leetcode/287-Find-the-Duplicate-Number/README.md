
Binary search.  First of all, set mid place and see if amount of elements less than mid is more than mid, if it is, then the duplicate appears in left...mid, otherwise it appears in mid...right.  

Shrink the scope we will get the one that is duplicate, assuming there is only one. 
Space O(1),  Time O(nlogn).  
===========================================
Search online, there is a way to like cyclic linked list II, which is Space O(1),  Time O(n) 

So,  how can one come up such ideas? Note that index is pointing to an address, it is like a pointer, so it is value and pointer relationship, just like a linked list.   

