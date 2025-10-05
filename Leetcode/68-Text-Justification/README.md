
Prepare a cur move from 0 to word.length, and build line using a List<String> list. 

For each line, maxWidth >= sum + list.size()-1, if not,  build a line and add to result set. 

For building a line, we need the list, need length of each space, and need carry.
If cur runs to the end of words array,  then directly append the remaining space quota.  

Time O(n), Space O(n).  

  