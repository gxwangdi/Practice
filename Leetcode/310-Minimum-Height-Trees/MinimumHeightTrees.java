import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();      
        if (n < 3) {
            int cur = 0;
            while (cur < n) {
                res.add(cur);
                cur++;
            }
            return res;
        }
        List<Integer>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (graph[i].size() == 1) {
                leaves.add(i);
            }
        }
        
        int count = n;
        while (count > 2) {
            int size = leaves.size();
            count -= size;
            List<Integer> newLeaves = new ArrayList<>();
            for (int i=0; i<size; i++) {
                int leaf = leaves.get(i);
                for (int j=0; j<graph[leaf].size(); j++) {
                    int toRemove = graph[leaf].get(j);
                    // Pay attention to here:
                    // If pass in an int, it is search by index
                    // If integer, it is search by element. 
                    graph[toRemove].remove(Integer.valueOf(leaf)); 
                    
                    if (graph[toRemove].size() == 1) {
                        newLeaves.add(toRemove);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }// end of findMinHeightTrees
}








