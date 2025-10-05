
Talk to interviewer before actual coding ! ! ! ! 

What is special about this problem is, 
1. It guarantee to have one solution;
2. It might have cycle in the middle, in this case, can not use unique place to identify if all tickets are involved, using int param, currently processed number and total ticket number to see.  Note that it should be tickets.length+1. 
3. If multiple solutions exist, then take the one that is optimal in lex order, but first it will need to have a valid solution. 
-----------------------------------------------------
We need to use a map<String, List<String>> to organize the graph, and using dfs. We always put preference to the lex small choice so the earliest valid answer has a lower lex order.     

----------------------------------------------------
Use a map<String, List<String>> to persist the <from, to> mappings, and for all values inside the map, sort all the values in the map so that they are all in lex order.   

Start from JFK, for each iteration,  get the dst in the value list, and remove the dst from the value list, and add the dst to result set, set as the starting point for next iteration.   

Space O(n), Time O(n).    


 