More like binary search.  Find the largest number i in range 0~x so that i*i<=x.   

Space O(1), Time O(logx).     

PAY Attention to the integer overflow issue!   left, right and mid should be long, even when x is int.  

=====================================
Search online and found Newton recursion that can be used to resolve this issue. 
https://en.wikipedia.org/wiki/Newton%27s_method    

=====================================
Search online and there is a O(1) method to get sqrt(n).  Listed in cpp file.   

This is crazy! How can I figure out this in an interview?      

  