
Define a BST, with cutomized node:
class Node {
int val;
int dup; // duplicate
int leftTreeSize;//
}    

Then we can build the tree scanning the original array from tail to head.    
Everytime we add something, update dup and leftTreeSize along the route,  and collect the result from the dup and leftTreeSize;    

