import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SparseMatrixMultiplecation {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return null;
        }
        
        int I = A.length;
        int J = A[0].length;
        int K = B[0].length;
        Map<Integer, Set<Pair>> mapA = new HashMap<>();
        Map<Integer, Set<Pair>> mapB = new HashMap<>();
        
        for (int i=0; i<I; i++) {
            for (int j=0; j<J; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                if (mapA.containsKey(j)) {
                    Set<Pair> set = mapA.get(j);
                    set.add(new Pair(A[i][j], i));
                } else {
                    Set<Pair> set = new HashSet<>();
                    set.add(new Pair(A[i][j], i));
                    mapA.put(j, set);
                }
            }
        }// end of A preprocessing
        
        for (int j=0; j<J; j++) {
            for (int k=0; k<K; k++) {
                if (B[j][k] == 0) {
                    continue;
                }
                if (mapB.containsKey(j)) {
                    Set<Pair> set = mapB.get(j);
                    set.add(new Pair(B[j][k], k));
                } else {
                    Set<Pair> set = new HashSet<>();
                    set.add(new Pair(B[j][k], k));
                    mapB.put(j, set);
                }
            }
        }
        
        int[][] C = new int[I][K];
        for (Integer j: mapA.keySet()) {
            if (!mapB.containsKey(j)) {
                continue;
            }
            Set<Pair> setA = mapA.get(j);
            Set<Pair> setB = mapB.get(j);
            for (Pair pa:setA) {
                for (Pair pb:setB) {
                    C[pa.index][pb.index] += pa.val*pb.val;
                }
            }
        }
        return C;
    }
    
    private static class Pair {
        public int val;
        public int index;
        public Pair(int v, int i) {
            val = v;
            index = i;
        }
    }
}