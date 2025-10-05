public class GraphValidTree {
    
    // Union Find solution
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge:edges) {
            int x = edge[0];
            int y = edge[1];
            if (!uf.union(x, y)) {
                return false;
            }
        }
        return uf.count == 1;
    }
    
    private static class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i=0; i<n; i++) {
                parent[i] = i;
            } 
        }
        
        int find(int x) {
            if (x!=parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }// end of find   
        
        boolean union(int x, int y) {
            int X = find(x);
            int Y = find(y);
            if (X == Y) {
                return false;
            }
            if (rank[X] > rank[Y]) {
                parent[Y] = X;
            } else if (rank[Y] > rank[X]) {
                parent[X] = Y;
            } else {
                rank[X]++;
                parent[Y] = X;
            }
            count--;
            return true;
        }
    }
    
    /*
    // BFS
    public boolean validTree(int n, int[][] edges) {
        if (n < 1 || edges == null) {
            return false;
        }
        if (edges.length != n-1) {
            return false;
        }
        int[] visited = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] =1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int succ : adj.get(cur)) {
                if (visited[succ] == 1) {
                    return false; // has cycle
                }
                if (visited[succ] == 0) {
                    q.offer(succ);
                    visited[succ] = 1;
                }
            }
            visited[cur] = 2; // visite completed.
        }
        for (int v:visited) {
            if (v == 0) {
                return false;
            } 
        }
        return true;
    }
    */
    
    /*
    // DFS   
    public boolean validTree(int n, int[][] edges) {
        if (n < 1 || edges == null) {
            return false;
        }
        if (edges.length != n-1) {
            return false;
        }
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        if (hasCycle(-1, 0, adjList, visited)) {
            return false;
        }
        for (int v:visited) {
            if (v == 0) {
                return false;
            }
        }
        return true;
    }// end of validTree   
    
    private boolean hasCycle(int prev, int cur, List<List<Integer>> adj, int[] visited) {
        visited[cur] = 1;
        for (int succ : adj.get(cur)) {
            if (succ == prev) {
                continue;
            }
            if (visited[succ] == 1) {
                return true; // loop
            }
            if (visited[succ] == 0) {
                if (hasCycle(cur, succ, adj, visited)) {
                    return true;
                }
            }
        }// end of succ loop
        visited[cur] = 2;
        return false;
    }// end of hasCycle   
    */
    
    
}





