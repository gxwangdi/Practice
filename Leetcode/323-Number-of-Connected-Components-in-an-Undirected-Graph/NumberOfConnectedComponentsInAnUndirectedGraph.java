public class NumberOfConnectedComponentsInAnUndirectedGraph {
    
    // Union Find 
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount();
    }
    
    private static class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for(int i=0; i<n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (x!=parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public boolean union(int i, int j) {
            int I = find(i);
            int J = find(j);
            if (I == J) {
                return false;
            }
            if (rank[I] > rank[J]) {
                parent[J] = I;
            } else if (rank[I] < rank[J]) {
                parent[I] = J;
            } else {
                rank[I]++;
                parent[J] = I;
            }
            count--;
            return true;
        }
        
        public int getCount() {
            return count;
        }
    }
}





