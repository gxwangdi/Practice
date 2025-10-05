import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class RouteBetweenTwoNodesInGraph {
	/**
	 * @param graph: A list of Directed graph node
	 * 
	 * @param s: the starting Directed graph node
	 * 
	 * @param t: the terminal Directed graph node
	 * 
	 * @return: a boolean value
	 */
	public boolean hasRoute(List<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		return dfs(graph, s, t, visited);
	}

	private boolean dfs(List<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t,
			Set<DirectedGraphNode> visited) {
		if (s == t) {
			return true;
		} else {
			// corner cases
			if (s == null || t == null)
				return false;
			// flag visited node, avoid cylic
			visited.add(s);
			// compare unvisited neighbor nodes recursively
			if (s.neighbors.size() > 0) {
				for (DirectedGraphNode node : s.neighbors) {
					if (visited.contains(node))
						continue;
					if (dfs(graph, node, t, visited))
						return true;
				}
			}
		}

		return false;
	}

	/* // BFS
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
		if (graph == null || s == null || t == null)
			return false;

		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		q.offer(s);
		while (!q.isEmpty()) {
			int qLen = q.size();
			for (int i = 0; i < qLen; i++) {
				DirectedGraphNode node = q.poll();
				visited.add(node);
				if (node == t)
					return true;
				// push neighbors into queue
				if (node.neighbors.size() > 0) {
					for (DirectedGraphNode n : node.neighbors) {
						// avoid cylic
						if (visited.contains(n))
							continue;
						q.offer(n);
					}
				}
			}
		}
		return false;
	}*/
}
