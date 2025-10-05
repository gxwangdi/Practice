
Naive solution would be, based on isAnagram(String, String), check one by one. It has O(n2m), n is the size of strings, m is the average length of the strings.

=========================================
Just check the answer from jiuzhang.com, it gets a count int array for each string, and compute a hash based on that. Use the hash code as the entry in the hashmap.

