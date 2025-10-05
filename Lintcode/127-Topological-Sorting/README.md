
Normally, a BFS is more straight forward.

Put the nodes without in-degree into a queue.

Everytime we pop something from a queue, remove dependencies it imposes on other nodes, and if some of the other nodes do not have in-degree, then put them into the queue.

