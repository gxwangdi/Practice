
x = a%b = mb + a1;
ax = amb + aa1 = (am+ am1)b + a2;

The remainder transfers and there must be a loop. Prepare a set to get the loop, say size x, and only calcualte n%x, and if we could make it ordered, then we can get the answer directly.

So it should be a list to check the entry of the loop.

Space O(b), Time O(b)
The best solution is like pow(x, y), collect fastPow(a, b, n/2) and process and pass back, which is to reuse partial result. 

Space O(logn), Time O(logn)

