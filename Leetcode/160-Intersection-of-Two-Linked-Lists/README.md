
Well, a straight forward solution is like, add one whole linkedlist to a list, and add another into another linkedlist, and reverse them both, and compare the first different node.    It takes extra O(m+n) space, O(Max(m,n)) time.    

For extra O(1) space, what I can think of is, get the length of each linkedlist, and take the longer linkedlist and make couple of steps prior, and move the two linkedlist forward at the same pace and compare.   

Space O(1), Time O(Max(m,n))   
