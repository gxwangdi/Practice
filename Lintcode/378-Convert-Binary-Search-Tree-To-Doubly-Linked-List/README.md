
Recursive approach is like,
DoublyListNode[] toDoublyList(TreeNode node) returns an array,

arr[0] means the head of the list in the subtree rooted at node;
while arr[1] mean the tail of the list.

Iterative approach is like, 
Prepare a dummy doubly node and cur, iteratively traverse the tree in order, transfer a doubly list node and append it to the cur when visiting a tree node.

