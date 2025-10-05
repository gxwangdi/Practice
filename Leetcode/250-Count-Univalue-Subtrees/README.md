
Basically D&Q !  

For each level, pass back a Result<T/F,  Val,  Count>. 

If left.F || right.F, then return <F, Val, left.count + right.count>

If node.val == left.Val == right.Val,  return <T, node.val, 1 + left.count + right.count>          

else return <F, node.val, left.count + right.count>      

Time O(n).    Space O(1)     

