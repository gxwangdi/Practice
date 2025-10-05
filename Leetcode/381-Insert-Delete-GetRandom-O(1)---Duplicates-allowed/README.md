
First of all, we need to insert in O(1), so using a hashmap<V, count>, V is the value we insert, count is how many duplicate value is there. 

If we do not want to make hybrid value, then need another map<V, ListNode>, V is the value we put in, ListNode is the head node of which the val of each node is a count, the entry of that value in the third map. 

We can have a third map<Integer, V>, integer is the key of a map.         
====================================================

Something wrong and my approach does not work.   Put a star and will figure it out later.    



 
