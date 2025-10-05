/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

class Relation {
	boolean knows(int a, int b) {
		return false;
	}
}

public class FindTheCelebrity extends Relation {
    
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i=1; i<n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i=0; i<n; i++) {
            if (i!= candidate && (!knows(i, candidate) || knows(candidate, i) )) {
                return -1;
            }
        }
        return candidate;
    }
    
    /*
    // My implementation is just too lengthy....
    public int findCelebrity(int n) {
        if (n<=0) {
            return -1;
        }
        
        List<Integer> res = new ArrayList<>();
        boolean isAC = true;
        for (int i=1; i<n; i++) {
            if (knows(0,i)) {
                isAC = false;
                if (!knows(i, 0)) {
                    res.add(i);
                }
            }
        }// init result set.
    }
    */
}



