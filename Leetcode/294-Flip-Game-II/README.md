
The final result is best to be "+-- +-- +-- ... +-- +"   looks like 3n+1, assuming the competitor knows optimal strategy as well.  

len/3, 
if it is even,  check len%3 0 or 1 for lose, 2 for win;
if it is odd, check len%3, 2 for lose, 0 or 1 for win.    O(1) 
This assumes the input is all '+'s, which is not true!   It is not a math problem.  
=========================================================

Well, based on generateNextMove(String) in Flip Game, we can do level order search, and see the number of deepest level is odd or even. 
If it is even, starter loses,  
or starter wins if it is odd. 

=========================================================

jiuzhang provides a search solution, which is pretty new that dfs can run this way.  

And a nimble game solution.   



  
