import java.util.LinkedList;

public class SnakeGame {

    /*
    private static class Position {
        public int x;
        public int y;
        
        public Position(int i, int j) {
            x = i;
            y = j;
        }
        
        public boolean equals(Position pos) {
            return this.x == pos.x && this.y == pos.y;
        }
    }// end of class position.
    
    private static class Snake{
        Set<Position> points;
        Queue<Position> body;
        
        int direction; // 0 for right, 1 for up, 2 for left, and 3 for down. 
        int length;
        Position head;
        public Snake() {
            direction =0;
        }
        
        public void resume() {
            length =1;
            direction = 0;
            points = new HashSet<>();
            body = new LinkedList<>();
            head = new Position(0,0);
            points.add(head);
            body.offer(head);
        }
        
        public void move() {
            // Based on head and direction;
            // add new postion into body, remove the last position out from the body.
        }
        
        public int getLength() {
            return length;
        }
        
        public void setLength(int len) {
            length = len;
        }
        
        public void eat(Postion pos) {
            // Add the food to the head, change length. 
        }
        
        public boolean isDead(int[][] board) {
            // Check if head is out of board;
            // If it bites itself.
        }
        // public void die(SnakeGame sg) {
            
        // }
    }// end of class snake    
    */
    
    int[][] food;
    int width;
    int height;
    int foodIndex;
    LinkedList<int[]> track;
    
    // private int[][] board;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        // width = Math.max(1, width);
        // height = Math.max(1, height);
        // board = new int[width][height];
        
        this.width = width;
        this.height = height;
        this.foodIndex = 0;
        this.food = food;
        track = new LinkedList<>();
        int[] n = {0,0};
        track.add(n);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int x = track.get(0)[0];
        int y = track.get(0)[1];
        int[] newpoint = new int[2];
        if (direction.equals("U")) {
            x = x-1;
            y = y;
        } else if (direction.equals("L")) {
            x = x;
            y = y-1;
        } else if (direction.equals("R")) {
            x = x;
            y = y+1;
        } else {
            x = x+1;
            y = y;
        }
        
        if (x<0 || x>=height || y<0 || y>=width) {
            return -1;
        }
        newpoint[0] = x;
        newpoint[1] = y;
        int[] todelete = track.get(track.size()-1);
        track.remove(track.size()-1);
        
        if (isdead(x, y)) {
            return -1;
        }
        track.add(0, newpoint);
        if (food.length > foodIndex 
            && x == food[foodIndex][0] 
            && y == food[foodIndex][1]) {
            track.add(todelete);    
            foodIndex++;
            return foodIndex;
        }
        return foodIndex;
    }
    
    public boolean isdead(int x, int y) {
        for (int i=track.size()-1; i>=0; i--) {
            int[] t = track.get(i);
            if (t[0] == x && t[1] == y) {
                return true;
            }
        }
        return false;
    }// end of isdead.     
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
 
 
 
 
 
 
 
 
 
 
 
 