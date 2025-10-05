
One way is , to generate inorder and preorder sequence, separated by an impossible char like #.

When deserializing, deserialize from the two strings.

And we can use the way OJs use, which is BFS, and remove trailling #s.

PAY ATTENTION: 
1. When cur moves to check right node value, it is possible for outOfBoundException.
2. When serializing the tree, think of the case where root is null, which impacts for the res list. 
3. .....

