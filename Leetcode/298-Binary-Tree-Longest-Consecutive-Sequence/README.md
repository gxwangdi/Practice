
D&Q approach.   Do not access null node, and child node pass <Count, Val> to parent.   

For left and right respectively,  

if node.val == left.Val-1; then count = max( count, left.Count+1);    

and update max[],  as the max could happen in the middle, not pass to the root.   

