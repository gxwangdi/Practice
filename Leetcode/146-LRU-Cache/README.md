
Basically a map storing the <key, value> content, the value is a node{key, value, next, prev}, which is maintained in a linked list.   

Use the linked list to build a queue, and access or insert would make it to the top, after it exceeds the size, remove it and the entry in the map.  
============================================
The idea is easy, to implement it bug free within one round is hard! That is why it is hard!       

1. Implement the basic function,  like get, set for the map structure.  
2. For the linked list operations,  break it into basic private helper functions. In this case it is remove(node) and setHead(node),  and implement them separately, thinking about varieties of situations.   This could easily reduce the difficulties.      



   
   

 