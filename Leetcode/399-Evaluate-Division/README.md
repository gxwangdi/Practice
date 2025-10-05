
This is like for equations and values, build a weighted graph.   

Based on given query [A, B], find a route from A to B in the graph.  

So we use a map to represent the weighted graph, like 
<A, <B, weight>>, and for each equation A / B = v 
we will have  two entries: <A, <B, v>> and <B, <A, 1/v>>.   

 Well, just find a posting that is close to what I was thinking:  
https://discuss.leetcode.com/topic/58539/graph-java-solution   

