

class Findwinneronatictactoegame {
    public String tictactoe(int[][] moves) {
        int d1 = 0, d2= 0;
        int[] rows = new int[3];
        int[] cols = new int[3];

        int turn = 1;
        for(int[] move : moves){
            int r = move[0];
            int c = move[1];
            if(r == c) d1+=turn;
            if(r + c == 2) d2+=turn;
            rows[r]+=turn;
            cols[c]+=turn;

            if(Math.abs(d1) == 3 || Math.abs(d2) == 3 ||
              Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3) return turn == 1 ? "A" : "B";

            turn *= -1;
        }
        return moves.length == 9? "Draw" : "Pending";
    }
}
