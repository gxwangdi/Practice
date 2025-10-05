import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* Definition for Directed graph.*/
class DirectedGraphNode {
	int label;
	List<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};

public class TopologicalSorting {
	/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> result = new ArrayList<>();
		Map<DirectedGraphNode, Integer> map = new HashMap<>();

		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				if (map.containsKey(neighbor)) {
					map.put(neighbor, map.get(neighbor) + 1);
				} else {
					map.put(neighbor, 1);
				}
			}
		}
		Queue<DirectedGraphNode> q = new LinkedList<>();
		for (DirectedGraphNode node : graph) {
			if (!map.containsKey(node)) {
				q.offer(node);
				result.add(node);
			}
		}
		while (!q.isEmpty()) {
			DirectedGraphNode node = q.poll();
			for (DirectedGraphNode n : node.neighbors) {
				map.put(n, map.get(n) - 1);
				if (map.get(n) == 0) {
					result.add(n);
					q.offer(n);
				}
			}
		}
		return result;
	}
}
