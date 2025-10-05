import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class CLoneGraph {
    
    // DFS in recursive manner.    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        UndirectedGraphNode ugn = new UndirectedGraphNode(node.label);
        map.put(node, ugn);
        for (UndirectedGraphNode n : node.neighbors) {
            ugn.neighbors.add(clone(n, map));
        }
        return ugn;
    }
    
    /*
    // BFS in iterative manner.   
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        } 
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            if (map.containsKey(temp)) {
                continue;
            }
            UndirectedGraphNode peer = new UndirectedGraphNode(temp.label);
            map.put(temp, peer);
            
            for ( UndirectedGraphNode ugn:temp.neighbors ) {
                peer.neighbors.add(ugn);
                q.offer(ugn);
            }
        }
        return map.get(node);
    }
    */
}




