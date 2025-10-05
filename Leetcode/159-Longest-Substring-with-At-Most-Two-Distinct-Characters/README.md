
Well, use index i and j to build a sliding window,  use a map<Character, Integer> to check word frequency, if Integer equals to 0 just remove the key.  Use a var max to check the max length all the time.   

If map.size() <=2,  update max = max(max, j-i+1), and j++. 

else remove i from map, and i++. 




