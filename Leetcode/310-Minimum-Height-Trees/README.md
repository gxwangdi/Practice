A brute force approach would be:  

Build the graph in a map,
Start from each node, BFS and store <nodeLabel, depth>, into a max heap,  
and get the top until depth is different.     

Time O(n^2)   Space O(n)
=======================================
Reference a posting in discuss:   
https://discuss.leetcode.com/topic/36694/java-accepted-solution-remove-nodes-from-leave-to-root    

The idea is, remove leaf gradually, the last remaining nodes  would be the answer.  

It should be O(n), but search a specific object in an ArrayList introduces O(n), so overall Time O(n^2).       


