
For normal case, set pointer i and j, i points to s and j points to t. 

if s[i] == t[j],  move i and j forward,
else move j forward only;

when i reaches the end of s, return succ; when j reaches the end of t, return fail.  

For follow up: 
Create a Map<Character, List<Integer>>,  while key is the char, List<Integer> is the index key appears in t.  For <i, s[j]>f it can be found in map.get(s[0]) that is bigger than the i, then i is assigned the new index, and j++, until j reaches the end of s. Starts with <-1, s[0]>.          



