
To check if there is a route between two nodes in a directed graph is a basic problem in Graph, either DFS or BFS works. Need to check if there is cycle, if there is, do not take the route to avoid endless loop, but do not return there as there might be some other routes that satisfies.

DFS in recursive manner would be easy to implement, while BFS is harder for a one round bug free code.

