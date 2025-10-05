
Note: pay attention that there could be invalid input, that the words are not properly sorted. Verify this with interviewer before coding !     

I would think of this as a graph topology sort problem.  

use a map<Character key, Set<Character> value> to indicate the dependency, where chars in value are all chars that appear behind key.  

After comparing adjacent two words continuously, build the map, and take all keys in the map to sort, like insertion sort.     

=====================================
Reference a posting in discuss https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs   
and Topology sort here:
https://en.wikipedia.org/wiki/Topological_sorting     



