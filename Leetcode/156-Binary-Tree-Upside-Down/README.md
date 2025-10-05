
Well, guess I do not quite understand the question, right node would not be a root of a subtree, with its own children?  

Iterative approach using a stack would be complicated, here we use a recursive approach.  Even that is not straightforward.   

Reference here 
http://blog.csdn.net/whuwangyi/article/details/43186045  

For iterative approach, basically we use parent and right to hold the node in the last upper iteration, and move cur to cur.left as a start of next level.  As long as left is valid, we do not care about right.  No worry about NPE, as it is entirely from the input.  

Recursive approach is more straight forward. It does not care after next recursion where left node is, it only takes care the transition for parent, right, and left nodes, in the same layer.            




