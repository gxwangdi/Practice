
We can do iterative in-order traversal for the BST, and when we meet k1, mark, and start to take visited nodes into result set.

And stop when the traversal is done or we meet k2;

Well, since it is binary search tree, we can directly search k1, and stack only have elements from root to k1 and bigger than k1. This is a difficult thing to do.

jiuzhang`s official answer actually uses a global list and a recursive in-order to resolve it.

