public class BombEnemy {
    
    private final char wall = 'W';
    private final char enemy = 'E';
    private final char spot = '0';
    
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = 0;
        int[] col = new int[grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == wall) {
                    continue;
                }
                if (j == 0 || grid[i][j-1] == wall) {
                    row = killedEnemyRow(grid, i, j);
                }
                if (i == 0 || grid[i-1][j] == wall) {
                    col[j] = killedEnemyCol(grid, i, j);
                }
                if (grid[i][j] == spot) {
                    max = Math.max(row+col[j], max);
                }
            }
        }
        return max;
    }// end of maxKilledEnemies        
    
    
    private int killedEnemyRow(char[][] grid, int i, int j) {
        int res = 0;
        while (j <grid[0].length && grid[i][j]!=wall) {
            if (grid[i][j] == enemy) {
                res++;
            }
            j++;
        }
        return res;
    }// end of killedEnemyRow
    
    
    private int killedEnemyCol(char[][] grid, int i, int j) {
        int res = 0;
        while (i < grid.length && grid[i][j]!=wall) {
            if (grid[i][j] == enemy) {
                res++;
            }
            i++;
        }
        return res;
    }// end of killedEnemyCol
}






