
It could use union find, then it is from internal nodes, it is straight forward, with union find template it is fine, it is just a lot of coding.  

For BFS, we can use all 0s on the edge, and start from there, all adjacent 0s become something not 'X', say 'Y'. It is standard BFS, After it is done, change all left 0s to Xs, and revert all Ys to 0s. 

Space O(n2),  Time O(n2)   

 