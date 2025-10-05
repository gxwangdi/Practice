

class AllAncestorsOfANodeInADirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edges.length; i++) {
            graph[edges[i][1]].add(edges[i][0]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>();
            boolean[] visited = new boolean[n];
            helper(i, graph, list, visited);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    private void helper(int vtx, ArrayList<Integer>[] graph, List<Integer> ans, boolean[] visited) {
        visited[vtx] = true;
        for(int nbr : graph[vtx]){
            if(visited[nbr] == false){
                ans.add(nbr);
                helper(nbr, graph, ans, visited);
            }
        }
    }
}
