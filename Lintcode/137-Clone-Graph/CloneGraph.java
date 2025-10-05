import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



  // Definition for undirected graph.
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
 
public class CloneGraph {
	/**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return clone(map, node);
	}// end of cloneGraph

	private UndirectedGraphNode clone(
			Map<UndirectedGraphNode, UndirectedGraphNode> map,
			UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}

		UndirectedGraphNode ugn = new UndirectedGraphNode(node.label);
		map.put(node, ugn);
		for (UndirectedGraphNode n : node.neighbors) {
			ugn.neighbors.add(clone(map, n));
		}
		return ugn;
	}// end of clone
}
