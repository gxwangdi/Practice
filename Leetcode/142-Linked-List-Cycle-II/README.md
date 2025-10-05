

Have not figured out solution within 25min.   

Cracking the coding interview 2.5 solution explains this.   And an easier clarification is  here: 
http://www.cnblogs.com/hiddenfox/p/3408931.html     

1. What is the length of the cycle if there is one?  
When fast meets slow, make them move forward and start counting, when they meet again, get the counter.   `cause fast goes one more round than slow.  
Or when fast meets slow for the first time, fast stops, slow keeps moving, and count the steps when they meet for the next time.  

2. When they meet for the first time, slow = a + b,  fast = a +b + c + b, and fast = 2*slow.  so  2(a+b) = a+b+c+b;  =>  a+c!   
 

  