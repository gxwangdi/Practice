import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        double[] results = new double[queries.length];
        Map<String, List<String>> graph = buildGraph(equations, values);
        
        for (int i=0; i<queries.length; i++) {
            String[] query = queries[i];
            if ( query[0].equals(query[1]) && !graph.containsKey(query[0]) ) {
                results[i] = -1.0;
            } else {
                double result = computeResultDFS(graph, query);
                results[i] = result;
            }
        }
        return results;
    }// end of calcEquation       
    
    private double computeResultDFS(Map<String, List<String>> graph, String[] query) {
        String dividend = query[0];    
        String divisor = query[1];
        Set<String> visited = new HashSet<>();
        double result = 1.0;
        result = dfs(dividend, divisor, graph, visited);
        if (result < 0) {
            result = -1.0;
        }
        return result;
    }// end of computeResultDFS      
    
    private double dfs(String start, String end, Map<String, List<String>> graph, Set<String> visited) {
        if (start.equals(end)) {
            return 1.0;
        }
        if (visited.contains(start)) {
            return -1.0;
        }
        visited.add(start);
        List<String> edgesList = graph.get(start);   
        if (edgesList == null || edgesList.isEmpty()) {
            return -1.0;
        }
        double result = 1.0;
        for (String edge : edgesList) {
            String[] tokens = edge.split(" ");
            String next = tokens[0];
            double val = Double.parseDouble(tokens[1]);
            result = val * dfs(next, end, graph, visited);
            if (result > 0) {
                return result;
            }
        }
        return result;
    }// end of dfs           
    
    private Map<String, List<String>> buildGraph(String[][] equations, double[] values) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int i=0; i<equations.length; i++) {
            String sNode = equations[i][0];
            String eNode = equations[i][1];
            double value = values[i];
            String eEdge = eNode + " " + value;
            String sEdge = sNode + " " + (1/value);
            if ( graph.containsKey(sNode) ) {
                graph.get(sNode).add(eEdge);
            } else {
                List<String> edges = new ArrayList<>();
                edges.add(eEdge);
                graph.put(sNode, edges);
            }
            if ( graph.containsKey(eNode) ) {
                graph.get(eNode).add(sEdge);
            } else {
                List<String> edges = new ArrayList<>();
                edges.add(sEdge);
                graph.put(eNode, edges);
            }
        }
        return graph;   
    }// end of buildGraph           
    
    
    
}// end of Solution class     








