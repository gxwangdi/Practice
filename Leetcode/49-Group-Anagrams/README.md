
Naive solution would be, based on isAnagram(String, String), check one by one. It has O(n2m) Time complexity, n is the size of strings, m is the average length of the strings.

This is what I can figure out. 

=========================================
Just check the answer from jiuzhang.com, it gets a count int array for each string, and compute a hash based on that. Use the hash code as the entry of the hashmap.  

Time O(nm), it makes more sense if you somehow design a hash code computation for int array, and have confidence that it rarely conflicts.   

   



