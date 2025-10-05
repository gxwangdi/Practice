
Could use dfs, or bfs.   

The idea is the same: setup a size n visited array,  and start traversal. 

If any node is visited before, return false;
If any node is never visited at the end, return false;
otherwise return true.   

For Union Find,  set each node to be the root of themselves at the beginning. For each edge, if two node is in the same union set, return false, `cause there is circle in the case. At the end if there is more than one union set,  return false; otherwise return true. 


