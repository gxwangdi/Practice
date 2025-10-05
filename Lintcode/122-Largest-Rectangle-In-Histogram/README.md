
The optimal solution is to use a stack, which is increasing, to keep an index 
of the element. Compare the element from the index on top of the stack and 
current element. If current element is bigger, put it into the stack, else pop 
stack, and compute area. Repeat until the stack top mapping element is smaller 
than current element.   

Note that need to add a 0 at the end of height array, to make sure all elements 
are popped up from stack, assuming all elements are bigger than 0.   

   