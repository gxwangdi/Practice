
NOTE:  Really, really figure out every single piece before you start coding ! ! !  

Looks like sorting, firstly we sort all papers in ascending order, and compare from  last to 1,  check citations[0] and citations.length first.   

This is difficult in that, you will need to understand the relationship first, and figure out how to utilize index as extra space.    

Space O(1), Time O(nlogn).    
=========================================
For O(n) solution, we will need to use extra O(n) space.   

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.    

possible value of h index is between 0 and citation.length, so create an array count[len+1], citation[i] bigger or equal to len count on count[len] , otherwise add the reference count on count[citation[i]].  

and get suffix sum t for count array, and see at which index i that t >= i satisfies for the first time.   

   


