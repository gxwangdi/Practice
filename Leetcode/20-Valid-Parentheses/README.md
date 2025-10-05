
Basic idea is to use a stack, push symbols when getting '(', '[' or '{', pop and compare when getting ')', '[' or '{'.     

Space  O(n)   Time O(n)   

Or we can remove "()" "{}" or "[]", one at a time, until the string length does not change anymore.   And see if all symbols are removed.  

Space O(n)   Time O(n)    