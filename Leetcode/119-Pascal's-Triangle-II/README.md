
Note that k is index, actually we only need the previous row.   

Space O(n)   Time O(n2)      

Another way of thinking is, we can get the value directly based on pascal triangle fomula, on Row n column m, the value is C(n, m) = n!/(m! * (n-m)!).

So C(n,m-1)=n!/((m-1)!*(n-m+1)!), and C(n,m)=C(n,m-1)*(n-m+1)/m

And the rule of combination number could reduce half of the computation:
C(n, m) == C(n, n-m).
