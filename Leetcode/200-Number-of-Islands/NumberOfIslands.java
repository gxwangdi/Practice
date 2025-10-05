public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
    if(grid==null || grid.length==0||grid[0].length==0)
        return 0;
 
    int m = grid.length;
    int n = grid[0].length;
 
    int count=0;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(grid[i][j]=='1'){
                count++;
                merge(grid, i, j);
            }
        }
    }
 
    return count;
}
 
public void merge(char[][] grid, int i, int j){
    int m=grid.length;
    int n=grid[0].length;
 
    if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
        return;
 
    grid[i][j]='X';
 
    merge(grid, i-1, j);
    merge(grid, i+1, j);
    merge(grid, i, j-1);
    merge(grid, i, j+1);
}
    
    /*
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == wat) {
                    continue;
                }
                count++;
                q.offer(new Pair(i, j));
                merge(grid, m, n, q);
            }
        }
        return count;
    }
    
    private void merge(char[][] grid, int m, int n, Queue<Pair> q) {
        while (!q.isEmpty()) {
            Pair p = q.poll();
            grid[p.x][p.y] = wat;
            if (p.x > 0 && grid[p.x-1][p.y] == dot) {
                q.offer(new Pair(p.x-1, p.y));
            }
            if (p.x < m-1 && grid[p.x+1][p.y] == dot) {
                q.offer(new Pair(p.x+1, p.y));
            }
            if (p.y > 0 && grid[p.x][p.y-1] == dot) {
                q.offer(new Pair(p.x, p.y-1));
            }
            if (p.y < n-1 && grid[p.x][p.y+1] == dot) {
                q.offer(new Pair(p.x, p.y+1));
            }
        }
    }
    
    
    private static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private final char dot = '1';
    private final char wat = '0';
    */
}



