
Manually do the valid case and find the rule, pre-order is stack based approach.  

cur pointer scans every single char in s, if it is # create a null node and assign to node.left, push node into stack, and node = node.left.  

If node is null, pop from stack and assign to node, and cur moves to next one to get a new node as node.right, and node = node.right. Do not push it into stack.  

If there is anything unexpected in the process, then return false.  

