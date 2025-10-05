
Relative easy to think, but difficult to implement it correctly.  

PAY ATTENTION to corner case.

divisor==0 should be first, and then dividend==0, or if dividend is Integer.MIN_VALUE, as the absolute value of Integer.MIN_VALUE is bigger than that of Integer.MAX_VALUE;

Then we use bit shift operation, this is what I thought.    

For all the traps, reference http://fisherlei.blogspot.com/2012/12/leetcode-divide-two-integers.html 
一开始用的是Int，而不是Unsigned Int。带来的一个最直接的问题就是，如何处理INT_MIN(-2147483648)，比如 abs(-2147483648) = -2147483648。而进位的时候也麻烦，比如1073741824<<1， 结果不是2147483648， 而是-2147483648。所以把他们全部换成unsigned Int， 以避开这种麻烦。

刚开始的时候，两行并成一行
unsigned int migValue = dvs，i =0;
在替换完所有的int为unsigned int以后，立即犯了一个疏忽。
在处理比如（1,2）时，返回值是16777248， 而不是0。
原因就在于，当i被改为unsigned int后，如果i==0， i--会导致i变为2147483647， 而不是-1。
所以，拆分成两行，i的定义不变，仍然为int。

一开始只有 while（i>=0）， 没有剪枝，当dvd ==0的时候，没必要继续循环。加一个剪枝条件。也是第一次发现原来abs(INT_MIN)的值居然还是INT_MIN。直觉上，INT_MIN的这种特性，应该跟补码有关，但是懒得深究了。

关于溢出的问题，直接用unsigned long就解决了，省了很多不必要的比较和判断。
============================== Above is for C++   

For java, using negative to avoid overflow, details see the code comment.  

 


