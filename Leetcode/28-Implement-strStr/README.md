
Well, not sure why this is Easy, KMP is pretty complicated, which, personally is what this question is expecting.    

KMP tutorial:   https://www.youtube.com/watch?v=2ogqPWJSftE      

My thinking is like,  when it compares char by char for strings, it only compares value for integers, so somehow change it to integer first, and change substring(i, i+needle.length()) to integer, and compare.   

When the sliding window moves forward, we only need to take in the next, remove the last, and compute the new value based on that.  This is also O(n+m) time complexity.   To compute it, could use 26-ary for all lower case, 52-ary for all chars, and use BigDecimal or BigInteger in Java.

A simple implementation of the transfer function could be the hash function for collections. The bad thing is every time the sliding window moves forward, we need to scan every char again, and compute integer value based on that.   

A comprehensive description on all substring algorithm is available on wiki:
https://en.wikipedia.org/wiki/String-searching_algorithm  
