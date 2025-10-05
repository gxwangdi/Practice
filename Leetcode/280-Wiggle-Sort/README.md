
Have not come up anything with this at first.  

Brute force approach would be: 
To sort the whole array first, and get the last half and merge with the first half.     

Time O(nlogn),  Space O(n)   
======================================
Reference a posting here:  
https://discuss.leetcode.com/topic/23871/java-o-n-solution      

The idea is simple,  when element at odd position is smaller than its previous element, which is at even position, then swap the two.  In this way, make sure previous part is always align to the wiggle sequence.   

Accordingly, when element at even position is bigger than its previous element, which is at odd position, then swap the two. 

Time O(n)   Space O(1).         

Note that,  to deal with previous part, make it align specific requirements.     

     