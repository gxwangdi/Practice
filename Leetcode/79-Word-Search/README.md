
Basically dfs.  

we have recursive approach like
isMatch(char[][] src, int x, int y, boolean[][] visited, String target, int progress).   

Note that while while src would never change, visited would change, so revert it back once  we use it!     

Pay attention to top/bottom left/right, how to use a loop to check the four direction.
Especially if(di*dj != 0) continue; to exclude diagonal element.   

  
