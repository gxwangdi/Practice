import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length ==0 ) {
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Coordinate> q = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] != 0) {
                    continue;
                }
                q.offer(new Coordinate(i, j));
            }
        }
        
        while (!q.isEmpty()) {
            Coordinate c = q.poll();
            if (rooms[c.x][c.y] < c.eVal) {
                continue;
            }
            rooms[c.x][c.y] = c.eVal;
            if (c.x > 0 && rooms[c.x-1][c.y]!= wall) {
                q.offer(new Coordinate(c.x-1, c.y, c.eVal+1));
            }
            if (c.x < m-1 && rooms[c.x+1][c.y] != wall) {
                q.offer(new Coordinate(c.x+1, c.y, c.eVal+1));
            }
            if (c.y > 0 && rooms[c.x][c.y-1] != wall) {
                q.offer(new Coordinate(c.x, c.y-1, c.eVal+1));
            }
            if (c.y < n-1 && rooms[c.x][c.y+1] != wall) {
                q.offer(new Coordinate(c.x, c.y+1, c.eVal+1));
            }
        }
    }
    
    private final int wall = -1;
    
    private static class Coordinate {
        public int x;
        public int y;
        public int eVal; // expected Value
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.eVal = 0;
        }
        
        public Coordinate(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.eVal = val;
        }
    }
}




