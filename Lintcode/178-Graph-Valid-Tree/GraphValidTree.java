import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class GraphValidTree {
	/**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    /* // Union Find
    public boolean validTree(int n, int[][] edges) {
        if (n < 1 || n-1 != edges.length) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for (int i=0; i<edges.length; i++) {
            if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }*/
    
    /* // Recursive DFS
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
        }
        
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        if (!helper(0, -1, map, visited)) {
            return false;
        }
        for (boolean b: visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
    
    private boolean helper(int curr, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }
        visited[curr] = true;
        for(int i: map.get(curr)) {
            if (i != parent && !helper(i, curr, map, visited)) {
                return false;
            }
        }
        return true;
    }*/
    
    // BFS
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
        }
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            if (visited[top]) {
                return false;
            }
            visited[top] = true;
            for (int i: map.get(top)) {
                if (!visited[i]) {
                    queue.offer(i);
                }
            }
        }
        for (boolean b: visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}



class UnionFind {
    int[] parent;
    
    UnionFind(int n) {
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        return compressedFind(x);
    }
    
    public int compressedFind(int x) {
        int xParent = parent[x];
        while (xParent != parent[xParent]) {
            xParent = parent[xParent];
        }
        int temp = -1;
        int tParent = parent[x];
        while (tParent != parent[tParent]) {
            temp = parent[tParent];
            parent[tParent] = xParent;
            tParent = temp;
        }
        return xParent;
    }
    
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent != yParent) {
            parent[xParent] = yParent;
        }
    }
}
