Well, just check a posting in discuss,  and get an working answer.    

We need something to identify if it is a valid answer, which has valid quotes and max possible length.   

Check substring of S, if S.substring(2), S.substring(1, S.length-1) or S.substring(s.length-3).    

If it turns out to be a valid parentheses string, add to List collection.      

Space O(nlogn),   Time O(n).       Not thinking of how to handle multiple chars like 'a'.  
==================================================
Two rounds scan the string.
From left to right
If it is not ')', push into stack.   
If it is ')',  pop, if it is ')', dump, pop next;  if it is not ')', not '(', append to temp; if it is '(', append '(' first, and append temp, and append ')'.

From right to left     
If it is not '(', push into stack.
If it is '(', pop, if it is '(', dump, pop next; if it is not '(', not ')', append to temp; if it is ')', append ')' first, and append temp, and append '('.   

Space O(n),   Time O(n)    


https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution           
