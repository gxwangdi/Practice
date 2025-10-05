public class FlipGameII {
    
    
    
     // Search    
    public boolean canWin(String s) {
        if (s == null || s.length() <2) {
            return false;
        }
        boolean[] state = new boolean[s.length()];
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '+') {
                state[i] = true;
            } else {
                state[i] = false;
            } 
        }
        return search(state);
    }// end of canWin
    
    private boolean search(boolean[] state) {
        for (int i=0; i<state.length-1; i++) {
            if (state[i] && state[i+1]) {
                state[i] = false;
                state[i+1] = false;
                if (!search(state)) {
                    // competitor loses based on this action.
                    state[i] = true;
                    state[i+1] = true;
                    return true;
                } else {
                    state[i] = true;
                    state[i+1] = true;
                }
            }
        }
        return false;
    }// end of search.  
}




