
Note: pay attention to how recursive manner avoid duplicate cases.  

Will need to use a map<Node, Node> to map the nodes in existing graph, and the newly created graph.   

First of all, we will need to take the root of the newly created graph.   And assuming the given graph is connected, we will need to use a queue for BFS. I do not think we need a visited set of something in case of cycle, as the way it is serialized is kind of like directed graph, and deal with cycle properly.  

Space O(n),  Time O(n).   

 