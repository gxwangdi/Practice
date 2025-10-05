
Normally problem like this can be treated as a search problem.     

Use a map<Character, Integer>, or an int array if all elements are lower case, to keep track of the availability of each char.   

If it works, then return true, else return false;     

As it is asking for one valid answer, so it would be DFS.   
=================================================

Naive DFS gets TLE, use greedy algorithm.  The most left element available gets inserted first.  This makes sense as you would like to arrange chars that left most.   

Note that count[i] > max, that means if couple of chars have the same left count, then take it in lex order.  





  